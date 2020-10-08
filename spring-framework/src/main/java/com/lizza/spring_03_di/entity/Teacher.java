package com.lizza.spring_03_di.entity;

import java.util.List;
import java.util.Map;

/**
 * spring 依赖注入：集合注入
 */
public class Teacher {

    private List<String> students;
    private Map<String, Object> info;

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
