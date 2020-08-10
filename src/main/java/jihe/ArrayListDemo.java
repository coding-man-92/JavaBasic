package jihe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: 宋荣华
 * @date: 2020/4/3
 * @description mianshi.jihe
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        // 底层是一个object类型的数组，初始值为10
        // List<String> arrayList = new ArrayList();
        // 线程安全的ArrayList
        // Vector<String> arrayList = new Vector<>();
        // List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        // 高并发环境下ArrayList线程不安全demo(java.util.ConcurrentModificationException 并发修改异常)

        /**
         * 解决高并发环境下的ArrayList线程不安全问题：
         * 1.Vector   线程安全，并发性急剧下降
         * 2.Collections.synchronizedList(new ArrayList<String>() 使用Collections里面的同步方法
         * 3.java.util.concurrent.CopyOnwriteArrayList<E>   写时复制（读写分离思想）
         * public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             扩容加1
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         */
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(arrayList);
            }, String.valueOf(i)).start();
        }
    }
}
