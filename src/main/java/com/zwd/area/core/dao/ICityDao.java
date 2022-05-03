package com.zwd.area.core.dao;

import com.zwd.area.core.bean.auto.CityBean;
import com.zwd.area.core.bean.auto.CityBeanExample;
import com.zwd.area.core.dao.auto.CityBeanMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityDao extends CityBeanMapper {

}