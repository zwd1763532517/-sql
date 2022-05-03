package com.zwd.area.controller;

import com.zwd.area.core.bean.auto.*;
import com.zwd.area.service.SpiderService;
import com.zwd.area.util.HttpUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SpiderController {

    @Autowired
    private SpiderService spiderService;

    @GetMapping({"/", ""})
    public Object spider() throws Exception {
        String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/";
        String charset = "utf-8";
        Document rootDoc = HttpUtils.get(url, charset);
        if(rootDoc == null) {
            return 0;
        }
        Element firstElement = rootDoc.getElementsByClass("center_list_contlist").get(0);
        String yearHref = firstElement.select("a").get(0).attr("href"); // 最近一个年份的省份链接
        Document doc = HttpUtils.get(yearHref, charset);
        // 遍历所有的省
        Elements provinceElements = doc.getElementsByClass("provincetr");
        for (Element element : provinceElements) {
            Elements aEles = element.select("a");
            for (Element aEle : aEles) {
                String name = aEle.text();
                String provincesHref = aEle.attr("href");
                String code = provincesHref.substring(0, provincesHref.indexOf("."));
                int index = yearHref.lastIndexOf("/") + 1;
                provincesHref = yearHref.substring(0, index) + provincesHref;
                ProvinceBean province = new ProvinceBean();
                province.setCode(code);
                province.setName(name);
                spiderService.saveProvince(province);
                getCites(provincesHref, charset, code);
            }
        }
        return "spider crawl end.";
    }


    public void getCites(String url, String charset, String provinceCode) throws Exception {
        Document rootDoc = HttpUtils.get(url, charset);
        if(rootDoc != null) {
            Elements cityElements = rootDoc.getElementsByClass("citytr");
            for (Element cityElement : cityElements) {
                Element aEle = cityElement.select("a").get(1); // 第二个是市的名字
                String name = aEle.text();
                String cityHref = aEle.attr("href");
                CityBean city = new CityBean();
                city.setName(name);
                city.setProvinceCode(provinceCode);
                int start = cityHref.lastIndexOf("/") + 1;
                String code = cityHref.substring(start, cityHref.indexOf("."));
                city.setCode(code);
                spiderService.saveCity(city);

                int index = url.lastIndexOf("/");
                String substring = url.substring(0, index+1);
                String countyHref = substring + cityHref;

                getCounties(countyHref,charset,code);
            }
        }
    }

    @Async("taskExecutor")
    public void getCounties(String url, String charset, String cityCode) throws IOException {
        Document rootDoc = HttpUtils.get(url, charset);
        if(rootDoc != null) {
            Elements countyElements = rootDoc.getElementsByClass("countytr");
            for (Element countyElement : countyElements) {

                Elements a = countyElement.select("a");
                if(a.size()==0){
                    //当为市辖区时，需要特殊处理
                    Node node = countyElement.childNodes().get(1);
                    TextNode textNode = (TextNode)node.childNodes().get(0);
                    CountyBean county = new CountyBean();
                    county.setName(textNode.text());

                    Node node1 = countyElement.childNodes().get(0);
                    TextNode textNode1 = (TextNode)node1.childNodes().get(0);
                    county.setCityCode(cityCode);
                    county.setCode(textNode1.text().substring(0,6));
                    spiderService.saveCounty(county);
                }else{
                    Element aEle = countyElement.select("a").get(1); // 第二个是县/区的名字
                    String name = aEle.text();
                    String countyHref = aEle.attr("href");
                    CountyBean county = new CountyBean();
                    county.setName(name);
                    county.setCityCode(cityCode);
                    int start = countyHref.lastIndexOf("/") + 1;
                    String code = countyHref.substring(start, countyHref.indexOf("."));
                    county.setCode(code);
                    spiderService.saveCounty(county);

                    int index = url.lastIndexOf("/");
                    String substring = url.substring(0, index+1);
                    String townHref = substring + countyHref;

                    getTown(townHref,charset,code);
                }
            }
        }
    }

    public void getTown(String url, String charset, String CountyCode) throws IOException {
        Document rootDoc = HttpUtils.get(url, charset);
        if(rootDoc != null) {
            Elements townElements = rootDoc.getElementsByClass("towntr");
            for (Element townElement : townElements) {
                Element aEle = townElement.select("a").get(1); // 第二个是街道/乡镇的名字
                String name = aEle.text();
                String townHref = aEle.attr("href");
                TownBean town = new TownBean();
                town.setName(name);
                town.setCountyCode(CountyCode);
                int start = townHref.lastIndexOf("/") + 1;
                String code = townHref.substring(start, townHref.indexOf("."));
                town.setCode(code);
                spiderService.saveTown(town);

                int index = url.lastIndexOf("/");
                String substring = url.substring(0, index+1);
                String villageHref = substring + townHref;

                getVillage(villageHref,charset,code);
            }
        }
    }

    public void getVillage(String url, String charset, String townCode) throws IOException {
        Document rootDoc = HttpUtils.get(url, charset);
        if(rootDoc != null) {
            Elements villageElements = rootDoc.getElementsByClass("villagetr");
            for (Element villageElement : villageElements) {
                Node node = villageElement.childNodes().get(2);// 第二个是居委会的名字
                //String name = aEle.text();
                //TextNode node1 =(TextNode) node.childNodes().get(0);
                List<Node> nodes = node.childNodes();
                String name = ((TextNode)nodes.get(0)).text();
                VillageBean village = new VillageBean();
                village.setName(name);
                village.setTownCode(townCode);
                Node node1 = villageElement.childNodes().get(0);
                TextNode node2 = (TextNode)node1.childNodes().get(0);
                village.setCode(node2.text());
                spiderService.saveVillage(village);

            }
        }
    }
}
