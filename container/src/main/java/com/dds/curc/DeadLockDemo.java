package com.dds.curc;

import java.util.concurrent.TimeUnit;

/**
 * 拥有死锁的类
 */
class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public String getLockA() {
        return lockA;
    }

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void setLockA(String lockA) {
        this.lockA = lockA;
    }

    public String getLockB() {
        return lockB;
    }

    public void setLockB(String lockB) {
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有:" + lockA + "\t尝试获得:" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有:" + lockB + "\t尝试获得:" + lockA);
            }
        }
    }
}

/**
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.curc
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"AA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BB").start();
    }
}
//  死锁故障分析   在命令行输入jsp -l   查看进程编号
//  5360 sun.tools.jps.Jps
//  5236 org.jetbrains.jps.cmdline.Launcher
//  3304 mianshi.curc.DeadLockDemo
//  4620 org.jetbrains.idea.maven.server.RemoteMavenServer
//  4876 org.jetbrains.kotlin.daemon.KotlinCompileDaemon
//  5340
//  根据以上编号  使用jstack +可能出现问题的进程编号
//  Found one Java-level deadlock:
//=============================
//"BB":
//  waiting to lock monitor 0x0000000019bb8208 (object 0x00000007808451a0, a java.lang.String),
//  which is held by "AA"
//"AA":
//  waiting to lock monitor 0x0000000019bbab48 (object 0x00000007808451d8, a java.lang.String),
//  which is held by "BB"
//
//Java stack information for the threads listed above:
//===================================================
//"BB":
//        at mianshi.curc.HoldLockThread.run(DeadLockDemo.java:43)
//        - waiting to lock <0x00000007808451a0> (a java.lang.String)
//        - locked <0x00000007808451d8> (a java.lang.String)
//        at java.lang.Thread.run(Thread.java:748)
//"AA":
//        at mianshi.curc.HoldLockThread.run(DeadLockDemo.java:43)
//        - waiting to lock <0x00000007808451d8> (a java.lang.String)
//        - locked <0x00000007808451a0> (a java.lang.String)
//        at java.lang.Thread.run(Thread.java:748)
//
// Found 1 deadlock.   得出程序发生故障的原因是死锁