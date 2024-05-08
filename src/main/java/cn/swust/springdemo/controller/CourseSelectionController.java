package cn.swust.springdemo.controller;

import cn.swust.springdemo.pojo.Result;
import cn.swust.springdemo.service.CourseSelectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-student")
@Tag(name = "选课管理模块",description = "选课管理接口")
public class CourseSelectionController {
    @Autowired
    CourseSelectionService courseSelectionService;

    @GetMapping("/course-student")
    @Operation(summary = "查找指定课程ID的选课信息")
    public Result list(Long courseId){
        return Result.success(courseSelectionService.list(courseId));
    }

    @PostMapping("/course-student/{courseId}")
    @Operation(summary = "批量增加学生选课信息")
    public Result addCourseSelectionStudent(@PathVariable Long courseId,
                                            @RequestParam List<String> studentIds){
        courseSelectionService.add(courseId,studentIds);
        return Result.success();
    }

    @DeleteMapping("/course-student/{courseId}")
    @Operation(summary = "删除指定课程ID的学生选课信息")
    public Result deleteCourseSelectionStudent(@PathVariable Long courseId,
                                            @RequestParam List<String> studentIds){
        courseSelectionService.delete(courseId,studentIds);
        return Result.success();
    }
}
