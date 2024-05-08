package cn.swust.springdemo.service.impl;

import cn.swust.springdemo.mapper.CourseMapper;
import cn.swust.springdemo.mapper.CourseSelectionMapper;
import cn.swust.springdemo.mapper.StudentMapper;
import cn.swust.springdemo.pojo.CourseStudent;
import cn.swust.springdemo.pojo.Student;
import cn.swust.springdemo.pojo.vo.CourseSelectionVO;
import cn.swust.springdemo.pojo.vo.CourseVO;
import cn.swust.springdemo.service.CourseSelectionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseSelectionServiceImpl implements CourseSelectionService {
    @Autowired
    CourseSelectionMapper courseSelectionMapper;
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<CourseSelectionVO> list(Long courseId) {
        List<CourseSelectionVO> selectionVOS = new ArrayList<>();
        if(courseId == 0){
            courseId = null;
        }
        List<CourseStudent> list = courseSelectionMapper.list(courseId);
        for (CourseStudent courseStudent : list) {
            CourseSelectionVO courseSelectionVO = new CourseSelectionVO();

            CourseVO courseVO = courseMapper.list(courseStudent.getCourseId()).get(0);
            BeanUtils.copyProperties(courseVO,courseSelectionVO);
            courseSelectionVO.setSelectionId(courseStudent.getId());
            Student student = studentMapper.getById(courseStudent.getStudentId());
            courseSelectionVO.getStudents().add(student);

            selectionVOS.add(courseSelectionVO);
        }
        return selectionVOS;
    }

    @Override
    public void add(Long courseId, List<String> studentIds) {
        courseSelectionMapper.addBatch(courseId,studentIds);
    }

    @Override
    public void delete(Long courseId, List<String> studentIds) {
        courseSelectionMapper.deleteBatch(courseId,studentIds);
    }
}
