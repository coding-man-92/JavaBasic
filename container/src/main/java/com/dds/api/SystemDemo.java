package com.dds.api;

/**
 * @author: 宋荣华
 * @date: 2020/5/22
 * @description api
 */
public class SystemDemo {
    public static void main(String[] args) {
        // 终止当前运行的虚拟机
        // System.exit(1);
        // 运行垃圾回收器
        // System.gc();
        // 返回当前时间（以毫毛为单位）
        // System.currentTimeMillis();
        int[] a = {1, 2, 3};
        int[] b = new int[10];
        // 数组拷贝
        System.arraycopy(a, 2, b, 0, a.length);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
