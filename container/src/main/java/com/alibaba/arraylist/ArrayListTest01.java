package com.alibaba.arraylist;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: 宋荣华
 * @date: 2020/7/25
 * @description com.alibaba.arraylist
 */
public class ArrayListTest01 {
    /**
     * jdk1.8 arraylist源码分析
      */
    @Test
        public void fun(){
        ArrayList arrayList = new ArrayList(16);
        arrayList.add("19");
        // soutv
        System.out.println("arrayList = " + arrayList);

        }
}
