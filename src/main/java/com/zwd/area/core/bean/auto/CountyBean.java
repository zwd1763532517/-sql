package com.zwd.area.core.bean.auto;

public class CountyBean {
    private Integer id;

    private String cityCode;

    private String name;

    private String code;

    public CountyBean(Integer id, String cityCode, String name, String code) {
        this.id = id;
        this.cityCode = cityCode;
        this.name = name;
        this.code = code;
    }

    public CountyBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}