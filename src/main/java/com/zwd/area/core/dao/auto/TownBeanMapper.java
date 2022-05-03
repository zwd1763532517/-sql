package com.zwd.area.core.dao.auto;

import com.zwd.area.core.bean.auto.TownBean;
import com.zwd.area.core.bean.auto.TownBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TownBeanMapper {
    int countByExample(TownBeanExample example);

    int deleteByExample(TownBeanExample example);

    @Delete({
        "delete from town",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into town (id, name, ",
        "code, county_code)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{countyCode,jdbcType=VARCHAR})"
    })
    int insert(TownBean record);

    int insertSelective(TownBean record);

    List<TownBean> selectByExample(TownBeanExample example);

    @Select({
        "select",
        "id, name, code, county_code",
        "from town",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    TownBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TownBean record, @Param("example") TownBeanExample example);

    int updateByExample(@Param("record") TownBean record, @Param("example") TownBeanExample example);

    int updateByPrimaryKeySelective(TownBean record);

    @Update({
        "update town",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "county_code = #{countyCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TownBean record);
}