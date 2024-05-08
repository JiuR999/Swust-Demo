package cn.swust.springdemo.mapper;

import cn.swust.springdemo.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    void add(Student student);

    @Select("select * from student")
    List<Student> list();
    
    @Select("select * from student where id = #{id}")
    Student getById(long id);
    @Delete("delete from student where id = #{id}")
    void deleteById(long id);

    void update(Student student);

    List<Student> listEnrolledStudents(Long courseId);
}
