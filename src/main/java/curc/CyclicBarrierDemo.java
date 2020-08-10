package curc;


import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.lock
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 到达屏障点后,该线程才能执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t收集到第:" + tempInt + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
