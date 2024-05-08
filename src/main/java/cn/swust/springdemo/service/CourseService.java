package cn.swust.springdemo.service;

import cn.swust.springdemo.pojo.Course;
import cn.swust.springdemo.pojo.vo.CourseVO;

import java.util.List;

public interface CourseService {
    Course findByid(Long id);

    List<CourseVO> getAll();

    void deleteByid(Long id);

    void insert(Course course);

    void update(Course course);
}
