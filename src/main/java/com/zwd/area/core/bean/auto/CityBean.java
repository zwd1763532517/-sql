package com.zwd.area.core.bean.auto;

public class CityBean {
    private Integer id;

    private String provinceCode;

    private String name;

    private String code;

    public CityBean(Integer id, String provinceCode, String name, String code) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.name = name;
        this.code = code;
    }

    public CityBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
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