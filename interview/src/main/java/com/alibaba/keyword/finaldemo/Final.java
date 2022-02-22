package com.alibaba.keyword.finaldemo;

public class Final {
    final int max;
    Final(){
        max = 6;
    }

    public static void main(String[] args) {
        Final f = new Final();
        System.out.println(f.max);
        System.out.println("hahahah");
    }
}
