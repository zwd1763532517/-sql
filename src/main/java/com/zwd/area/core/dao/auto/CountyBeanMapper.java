package com.zwd.area.core.dao.auto;

import com.zwd.area.core.bean.auto.CountyBean;
import com.zwd.area.core.bean.auto.CountyBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CountyBeanMapper {
    int countByExample(CountyBeanExample example);

    int deleteByExample(CountyBeanExample example);

    @Delete({
        "delete from county",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into county (id, city_code, ",
        "name, code)",
        "values (#{id,jdbcType=INTEGER}, #{cityCode,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR})"
    })
    int insert(CountyBean record);

    int insertSelective(CountyBean record);

    List<CountyBean> selectByExample(CountyBeanExample example);

    @Select({
        "select",
        "id, city_code, name, code",
        "from county",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CountyBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CountyBean record, @Param("example") CountyBeanExample example);

    int updateByExample(@Param("record") CountyBean record, @Param("example") CountyBeanExample example);

    int updateByPrimaryKeySelective(CountyBean record);

    @Update({
        "update county",
        "set city_code = #{cityCode,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CountyBean record);
}