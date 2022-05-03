package com.zwd.area.service;

import com.zwd.area.core.bean.auto.*;

public interface SpiderService {

    /**
     *
     * @param province
     */
    void saveProvince(ProvinceBean province);

    void saveCity(CityBean city);

    void saveCounty(CountyBean county);

    void saveTown(TownBean town);

    void saveVillage(VillageBean village);
}
