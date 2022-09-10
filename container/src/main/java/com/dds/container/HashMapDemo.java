package com.dds.container;

import java.util.HashMap;

/**
 * @author: 宋荣华
 * @date: 2020/4/3
 * @description mianshi.jihe
 */
public class HashMapDemo {
    static int i;

    public int test() {
        i++;
        return i;
    }

    public static void main(String[] args) {
        HashMapDemo hashMapDemo = new HashMapDemo();
        System.out.println(hashMapDemo.test());
    }
}
