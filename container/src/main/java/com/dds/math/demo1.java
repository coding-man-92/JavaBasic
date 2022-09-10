package com.dds.math;

/**
 * @author: 宋荣华
 * @date: 2020/4/3
 * @description mianshi.math
 */

import sun.misc.Unsafe;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Math类测试
 */
class demo1 {
    public static void main(String[] args) {
        // round：四舍五入
        System.out.println(Math.round(-1.5));
        // floor：小于数值的最大值
        System.out.println(Math.floor(-1.5));
        // abs:数值的绝对值
        System.out.println(Math.abs(-1.5));
        // ceil:大于数值的最小值
        System.out.println(Math.ceil(-1.5));
    }
}
