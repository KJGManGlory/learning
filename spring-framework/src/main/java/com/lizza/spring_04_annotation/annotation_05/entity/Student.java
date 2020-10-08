package com.lizza.spring_04_annotation.annotation_05.entity;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-10-08
 */
public class Student {

    public Student() {
        System.out.println("Student Constructor Invoked ...");
    }

    private void init() {
        System.out.println("Student Init ...");
    }

    private void destroy() {
        System.out.println("Student Destroy ...");
    }
}
