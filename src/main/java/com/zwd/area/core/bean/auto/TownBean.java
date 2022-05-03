package com.zwd.area.core.bean.auto;

public class TownBean {
    private Integer id;

    private String name;

    private String code;

    private String countyCode;

    public TownBean(Integer id, String name, String code, String countyCode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.countyCode = countyCode;
    }

    public TownBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }
}