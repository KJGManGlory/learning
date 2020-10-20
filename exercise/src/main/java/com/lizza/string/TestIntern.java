package com.lizza.string;

/**
 * 测试String的intern方法
 */
public class TestIntern {

    public static void main(String[] args){
        String s1 = "计算机";
        String s2 = "计算机";
        System.out.println(s1.intern());
        System.out.println(s1 == s2);
    }
}
