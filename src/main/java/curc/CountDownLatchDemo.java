package curc;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计数工具类demo
 *
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.lock
 */
public class CountDownLatchDemo {
    final static int i = 6;

    public static void main(String[] args) throws InterruptedException {
        // 当CountDownLatch中的参数值为0后,其他线程才能访问该资源
        CountDownLatch countDownLatch = new CountDownLatch(i);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国被灭");
                countDownLatch.countDown();
            }, mianshi.curc.CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        // 枚举的取值方法,相当于一个数据版的mysql数据库
        // System.out.println(CountryEnum.ONE);
        // System.out.println(CountryEnum.ONE.getRetCode());
        // System.out.println(CountryEnum.ONE.getRetMessage());
        System.out.println(Thread.currentThread().getName() + "\t秦国统一");
    }
}
