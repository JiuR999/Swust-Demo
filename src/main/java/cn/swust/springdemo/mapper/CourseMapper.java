package cn.swust.springdemo.mapper;

import cn.swust.springdemo.pojo.Course;
import cn.swust.springdemo.pojo.vo.CourseVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from course where id = #{id}")
    Course findByid(Long id);

    List<CourseVO> list(Long id);

    @Delete("delete from course where id = #{id}")
    void deleteById(Long id);

    @Insert("insert into course(code,name,college_id) values(#{code},#{name},#{collegeId}) ")
    void insert(Course course);

    @Update("update course set code = #{code},name = #{name},college_id = #{collegeId} where id = #{id}")
    void update(Course course);
}
