package com.zwd.area.core.dao.auto;

import com.zwd.area.core.bean.auto.VillageBean;
import com.zwd.area.core.bean.auto.VillageBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface VillageBeanMapper {
    int countByExample(VillageBeanExample example);

    int deleteByExample(VillageBeanExample example);

    @Delete({
        "delete from village",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into village (id, name, ",
        "code, town_code)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{townCode,jdbcType=VARCHAR})"
    })
    int insert(VillageBean record);

    int insertSelective(VillageBean record);

    List<VillageBean> selectByExample(VillageBeanExample example);

    @Select({
        "select",
        "id, name, code, town_code",
        "from village",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    VillageBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VillageBean record, @Param("example") VillageBeanExample example);

    int updateByExample(@Param("record") VillageBean record, @Param("example") VillageBeanExample example);

    int updateByPrimaryKeySelective(VillageBean record);

    @Update({
        "update village",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "town_code = #{townCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VillageBean record);
}