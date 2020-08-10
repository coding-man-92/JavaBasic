package curc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用,实现A-B-C三个线程启动
 * A打印5次,B打印10次,C打印15次
 * 按照以上顺序来10次
 */

// 共享资源类
class ShareResource {
    // 定义标志变量
    private Integer num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1.判断标志变量
            while (num != 1) {
                c1.await();
            }
            // 2.干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3.通知其他线程并改变表示变量的值
            num = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 1.判断标志变量
            while (num != 2) {
                c2.await();
            }
            // 2.干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3.通知其他线程并改变表示变量的值
            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 1.判断标志变量
            while (num != 3) {
                c3.await();
            }
            // 2.干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3.通知其他线程并改变表示变量的值
            num = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 传统模式下的生产者消费者实现
 *
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.lock
 */
public class Demo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                shareResource.print5();
            }, "A").start();
        }
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                shareResource.print10();
            }, "B").start();
        }
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                shareResource.print15();
            }, "C").start();
        }
    }
}
