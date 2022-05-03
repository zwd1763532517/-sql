package com.zwd.area.core.dao.auto;

import com.zwd.area.core.bean.auto.CityBean;
import com.zwd.area.core.bean.auto.CityBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CityBeanMapper {
    int countByExample(CityBeanExample example);

    int deleteByExample(CityBeanExample example);

    @Delete({
        "delete from city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into city (id, province_code, ",
        "name, code)",
        "values (#{id,jdbcType=INTEGER}, #{provinceCode,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR})"
    })
    int insert(CityBean record);

    int insertSelective(CityBean record);

    List<CityBean> selectByExample(CityBeanExample example);

    @Select({
        "select",
        "id, province_code, name, code",
        "from city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CityBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityBean record, @Param("example") CityBeanExample example);

    int updateByExample(@Param("record") CityBean record, @Param("example") CityBeanExample example);

    int updateByPrimaryKeySelective(CityBean record);

    @Update({
        "update city",
        "set province_code = #{provinceCode,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CityBean record);
}