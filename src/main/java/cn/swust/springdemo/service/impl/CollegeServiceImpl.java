package cn.swust.springdemo.service.impl;

import cn.swust.springdemo.mapper.CollegeMapper;
import cn.swust.springdemo.pojo.College;
import cn.swust.springdemo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public List<College> list() {
        return collegeMapper.list();
    }

    @Override
    public void deleteById(long id) {
        collegeMapper.deleteById(id);
    }

    @Override
    public void add(College college) {
        collegeMapper.add(college);
    }

    @Override
    public void update(College college) {
        collegeMapper.update(college);
    }
}
