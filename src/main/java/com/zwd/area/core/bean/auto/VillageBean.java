package com.zwd.area.core.bean.auto;

public class VillageBean {
    private Integer id;

    private String name;

    private String code;

    private String townCode;

    public VillageBean(Integer id, String name, String code, String townCode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.townCode = townCode;
    }

    public VillageBean() {
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

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode == null ? null : townCode.trim();
    }
}