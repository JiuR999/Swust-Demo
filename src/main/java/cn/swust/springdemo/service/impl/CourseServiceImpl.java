package cn.swust.springdemo.service.impl;

import cn.swust.springdemo.mapper.CourseMapper;
import cn.swust.springdemo.pojo.Course;
import cn.swust.springdemo.pojo.vo.CourseVO;
import cn.swust.springdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
//    @Autowired
//    CourseRepository courseRepository;
    @Autowired
    CourseMapper courseMapper;
    @Override
    public Course findByid(Long id) {
        //courseRepository.findById(id);
        return courseMapper.findByid(id);
    }

    @Override
    public List<CourseVO> getAll() {
        return courseMapper.list(null);
    }

    @Override
    public void deleteByid(Long id) {
        courseMapper.deleteById(id);
    }

    @Override
    public void insert(Course course) {
            courseMapper.insert(course);
    }

    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }
}
