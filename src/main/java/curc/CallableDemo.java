package curc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.curc
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 若只有一个futuretask对象,则call方法仅会执行一次 AA/BB
        /*
          FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
          new Thread(futureTask, "AA").start();
          new Thread(futureTask, "BB").start();
        */
        // 需要执行两次call方法的话,则需要两个futuretask对象
        /**
         * 创建线程的方式:
         * 1.继承Thread类
         * 2.实现Runnable接口 run方法   无返回值也不抛异常
         * 3.实现callable接口并结合futuretask类(适配器模式) call方法  有返回值也会抛异常
         * 4.利用线程池
         */
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask1, "AA").start();
        new Thread(futureTask2, "BB").start();
        // 这行代码放在这里,则要等到AA线程执行完之后才执行后续代码,会导致阻塞,影响其他线程执行
        // int result1 = futureTask.get();
        System.out.println(Thread.currentThread().getName() + "\t**********");
        int result2 = 100;
        // call()方法中代码执行完后才执行后续代码
        /*while (!futureTask.isDone()) {

        }*/
        // 这行代码放在这里,则不需要等到AA线程执行完也能执行后续代码,不会阻塞,不影响其他线程执行
        int result1 = futureTask1.get();
        int result3 = futureTask2.get();
        System.out.println("result:" + (result1 + result2 + result3));
    }
}

class MyThread implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "*********come in callable");
        TimeUnit.SECONDS.sleep(5);
        return 1024;
    }
}