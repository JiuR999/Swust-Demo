package cn.swust.springdemo.controller;

import cn.swust.springdemo.pojo.Course;
import cn.swust.springdemo.pojo.Result;
import cn.swust.springdemo.service.CourseService;
import cn.swust.springdemo.validation.OnCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
@Tag(name = "Course-Controller", description = "课程管理模块")
public class CourseController {
    @Autowired
    CourseService courseService;
    private List<Course> courses = new ArrayList<>();

    @GetMapping("/getAll")
    @Operation(summary = "获取所有课程信息")
    public Result getAllCourse() {
        return Result.success(courseService.getAll());
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "根据课程id查询课程")
    public Course getCourseById(@Parameter(required = true, name = "id", description = "课程ID", example = "2") @PathVariable Long id) {
        return courseService.findByid(id);
    }

    @PostMapping("")
    @Operation(summary = "新增课程")
    @ResponseBody
    public String addCourse(@Validated(OnCreate.class) @RequestBody Course course) {
        Long id = Math.round(Math.random() * 1000);
        course.setId(id);
        courseService.insert(course);
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "根据id删除课程")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteByid(id);
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "根据id更新课程")
    public void updateCourse(@RequestBody Course course) {
        courseService.update(course);
    }
    public int getIndexById(Long id){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
//    /**
//     * 拦截本类中的验证异常， 把错误信息整理成易于前端处理的格式。
//     *
//     * @return
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        List errors = new ArrayList<String>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            errors.add(error.getDefaultMessage());
//        });
//        // 拼接结果
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("failure",true);  // 用于判断是否失败
//        result.put("message",errors);
//        return result;
//    }
}
