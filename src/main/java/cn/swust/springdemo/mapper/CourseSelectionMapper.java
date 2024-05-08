package cn.swust.springdemo.mapper;

import cn.swust.springdemo.pojo.CourseStudent;
import cn.swust.springdemo.pojo.vo.CourseSelectionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CourseSelectionMapper {
    List<CourseStudent> list(Long courseId);

    void addBatch(Long courseId, List<String> studentIds);

    void deleteBatch(Long courseId, List<String> studentIds);
}
