package com.dds.keyword.finaldemo;

public class FinalDemo {
    final int max;
    FinalDemo(){
        max = 6;
    }

    public static void main(String[] args) {
        FinalDemo f = new FinalDemo();
        System.out.println(f.max);
        System.out.println("hahahah");
    }
}
