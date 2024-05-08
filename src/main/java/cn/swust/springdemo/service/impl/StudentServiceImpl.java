package cn.swust.springdemo.service.impl;

import cn.swust.springdemo.mapper.StudentMapper;
import cn.swust.springdemo.pojo.Student;
import cn.swust.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public List<Student> listEnrolledStudents(Long courseId) {
        return studentMapper.listEnrolledStudents(courseId);
    }
}
