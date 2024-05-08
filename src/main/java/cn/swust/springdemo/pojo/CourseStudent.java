package cn.swust.springdemo.pojo;

import lombok.Data;

@Data
public class CourseStudent {
    private long id;
    private long courseId;
    private long studentId;
}
