package com.zwd.area.core.dao;

import com.zwd.area.core.bean.auto.TownBean;
import com.zwd.area.core.bean.auto.TownBeanExample;
import com.zwd.area.core.dao.auto.TownBeanMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITownDao extends TownBeanMapper {

}