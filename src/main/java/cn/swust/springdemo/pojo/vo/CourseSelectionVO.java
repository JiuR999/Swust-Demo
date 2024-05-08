package cn.swust.springdemo.pojo.vo;

import cn.swust.springdemo.pojo.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CourseSelectionVO extends CourseVO{
    protected Long selectionId;
    protected List<Student> students;

    public CourseSelectionVO() {
        students = new ArrayList<>();
    }
}
