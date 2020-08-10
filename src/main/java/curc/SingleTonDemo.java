package curc;

/**
 * @author: 宋荣华
 * @date: 2020/4/15
 * @description mianshi.curc
 */
public class SingleTonDemo {
    // 加入volatile修饰防止编译器指令重排序
    private static volatile SingleTonDemo singleTonDemo = null;

    public static SingleTonDemo getInstance() {
        // DCL(double check lock 双端检锁机制实现单例创建)
        if (singleTonDemo == null) {
            synchronized (SingleTonDemo.class) {
                if (singleTonDemo == null) {
                    /**
                     * 分成三步：1.给对象分配内存空间
                     *          2.初始化对象
                     *          3.设置singleTonDemo指向分配的内存地址（此时singleTonDemo！=null）
                     *          由于第二步和第三步没有存在数据依赖，
                     *          不加volatile修饰变量会存在指令重排的情况下执行顺序无法确定
                     */
                    singleTonDemo = new SingleTonDemo();
                }
            }
        }
        return singleTonDemo;
    }
}
