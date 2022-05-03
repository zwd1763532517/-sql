package com.zwd.area.core.dao.auto;

import com.zwd.area.core.bean.auto.ProvinceBean;
import com.zwd.area.core.bean.auto.ProvinceBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProvinceBeanMapper {
    int countByExample(ProvinceBeanExample example);

    int deleteByExample(ProvinceBeanExample example);

    @Delete({
        "delete from province",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into province (id, name, ",
        "code)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR})"
    })
    int insert(ProvinceBean record);

    int insertSelective(ProvinceBean record);

    List<ProvinceBean> selectByExample(ProvinceBeanExample example);

    @Select({
        "select",
        "id, name, code",
        "from province",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    ProvinceBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProvinceBean record, @Param("example") ProvinceBeanExample example);

    int updateByExample(@Param("record") ProvinceBean record, @Param("example") ProvinceBeanExample example);

    int updateByPrimaryKeySelective(ProvinceBean record);

    @Update({
        "update province",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProvinceBean record);
}