package curc;

import java.util.concurrent.*;

/**
 * 自定义线程池
 *
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.curc
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        // 查看本计算机cpu个数
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2, // 核心线程数
                5, // 最大线程数
                1L, // 时间单位
                TimeUnit.SECONDS, // 空闲线程的存活时间
                new LinkedBlockingDeque<>(3), // 阻塞队列(核心线程数满后任务便进入阻塞队列中等待)
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t处理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    /**
     * JDK自带的三种线程池,实际开发中不用,也不允许使用Executors创建,需要自己手写线程池
     */
    private static void threadPoolInit() {

        // 一池5线程
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 一池一线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 一池N线程(缓存随机扩容)
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t处理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
