package cn.swust.springdemo.controller;

import cn.swust.springdemo.pojo.Result;
import cn.swust.springdemo.pojo.Student;
import cn.swust.springdemo.service.StudentService;
import cn.swust.springdemo.validation.OnCreate;
import cn.swust.springdemo.validation.OnEdit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/student")
@Tag(name = "Student-Controller", description = "学生管理模块")
public class StudentController {
    @Autowired
    StudentService studentService;
    List<Student> students = new ArrayList<>();

    @RequestMapping("")
    public String student(Model model) {
        model.addAttribute("students", students);
        return "student/index";
    }

    @RequestMapping("/course")
    public String course() {
        return "student/course";
    }

    @GetMapping("/view")
    public String studentView(Model model, long id) {
        int idx = getStudentIndexById(id);
        if (idx != -1) {
            model.addAttribute("student", students.get(idx));
        }
        return "student/studentPage";
    }

    @PostMapping("/add")
    @Operation(summary = "新增学生")
    @ResponseBody
    public Result addStudent(@Validated(OnCreate.class) @RequestBody Student student) {
//        if(bindingResult.hasErrors()) {
//            // 有错误是回到form，此处同时自动把bindingResult绑定到form.html视图
//            return "student/index";
//        }
        // 没有错误时添加该学生并重定向到 /student 显示所有学生
        // 未学生分配一个随机整数（此处不保证所有学生Id唯一）
        Long id = Math.round(Math.random() * 1000);
        student.setId(id);
        studentService.add(student);
        return Result.success();
    }

    @PostMapping("/update")
    @Operation(summary = "更新学生信息")
    public String updateStudent(@Validated(OnEdit.class) @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/form";
        }
       studentService.update(student);
        return "redirect:/student";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Result getAll() {
        return Result.success(studentService.list());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "根据ID删除学生")
    public String deleteStu(@PathVariable long id) {
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("/not-enrolled-student/{courseId}")
    @ResponseBody
    @Operation(summary = "获取未选课学生信息")
    public Result enrolledStudents(@PathVariable Long courseId){
        List<Student> enrolledStudents = studentService.listEnrolledStudents(courseId);
        return Result.success(enrolledStudents);
    }

    private int getStudentIndexById(long id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
