package com.zwd.area.service.Impl;

import com.zwd.area.core.bean.auto.*;
import com.zwd.area.core.dao.*;
import com.zwd.area.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpiderServiceImpl implements SpiderService {

    @Autowired
    IProvinceDao iProvinceDao;

    @Autowired
    ICityDao iCityDao;

    @Autowired
    ICountyDao iCountyDao;

    @Autowired
    ITownDao iTownDao;

    @Autowired
    IVillageDao iVillageDao;


    @Override
    public void saveProvince(ProvinceBean province) {
        iProvinceDao.insertSelective(province);
    }

    @Override
    public void saveCity(CityBean city) {
        iCityDao.insertSelective(city);
    }

    @Override
    public void saveCounty(CountyBean county) {
        iCountyDao.insertSelective(county);
    }

    @Override
    public void saveTown(TownBean town) {
        iTownDao.insertSelective(town);
    }

    @Override
    public void saveVillage(VillageBean village) {
        iVillageDao.insertSelective(village);
    }
}
