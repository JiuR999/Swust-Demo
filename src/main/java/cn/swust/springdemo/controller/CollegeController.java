package cn.swust.springdemo.controller;

import cn.swust.springdemo.pojo.College;
import cn.swust.springdemo.pojo.Result;
import cn.swust.springdemo.service.CollegeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
@Tag(name = "学院管理接口",description = "学院管理接口")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @GetMapping("/list")
    @Operation(summary = "获取所有学院信息")
    public Result list(){
        return Result.success(collegeService.list());
    }

    @PostMapping("")
    @Operation(summary = "增加学院")
    public Result add(@RequestBody College college){
        collegeService.add(college);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除学院")
    public Result deleteById(@PathVariable long id){
        collegeService.deleteById(id);
        return Result.success();
    }

    @PutMapping("")
    @Operation(summary = "更新学院信息")
    public Result update(College college){
        collegeService.update(college);
        return Result.success();
    }

}
