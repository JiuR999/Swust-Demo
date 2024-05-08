package cn.swust.springdemo.service;

import cn.swust.springdemo.pojo.College;

import java.util.List;

public interface CollegeService {
    List<College> list();

    void deleteById(long id);

    void add(College college);

    void update(College college);
}
