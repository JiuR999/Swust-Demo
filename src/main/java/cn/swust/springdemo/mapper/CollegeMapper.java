package cn.swust.springdemo.mapper;

import cn.swust.springdemo.pojo.College;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollegeMapper{
    @Insert("insert into college(college_name) values (#{collegeName})")
    void add(College college);

    @Select("select * from college")
    List<College> list();

    @Delete("delete from college where id = #{id}")
    void deleteById(Long id);

    @Update("update college set name = #{name} where id = #{id}")
    void update(College college);
}
