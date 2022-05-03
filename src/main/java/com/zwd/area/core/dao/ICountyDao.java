package com.zwd.area.core.dao;

import com.zwd.area.core.bean.auto.CountyBean;
import com.zwd.area.core.bean.auto.CountyBeanExample;
import com.zwd.area.core.dao.auto.CountyBeanMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountyDao extends CountyBeanMapper {
}