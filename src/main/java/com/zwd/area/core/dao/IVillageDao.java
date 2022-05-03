package com.zwd.area.core.dao;

import com.zwd.area.core.bean.auto.VillageBean;
import com.zwd.area.core.bean.auto.VillageBeanExample;
import com.zwd.area.core.dao.auto.VillageBeanMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVillageDao extends VillageBeanMapper {

}