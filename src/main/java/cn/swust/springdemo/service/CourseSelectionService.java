package cn.swust.springdemo.service;

import cn.swust.springdemo.pojo.vo.CourseSelectionVO;

import java.util.List;

public interface CourseSelectionService {
    List<CourseSelectionVO> list(Long courseId);

    void add(Long courseId, List<String> studentIds);

    void delete(Long courseId, List<String> studentIds);
}
