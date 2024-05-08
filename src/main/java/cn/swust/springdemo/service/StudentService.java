package cn.swust.springdemo.service;

import cn.swust.springdemo.pojo.Student;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface StudentService {

    void add(Student student);

    List<Student> list();

    void update(Student student);

    void delete(long id);

    List<Student> listEnrolledStudents(Long courseId);
}
