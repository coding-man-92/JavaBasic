package jihe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: 宋荣华
 * @date: 2020/4/9
 * @description mianshi.jihe
 */
public class HashSetDemo {
    public static void main(String[] args) {
        // 底层是hashmap，初始容量为16，负载因子0.75  线程不安全
        // Set<String> set = new HashSet<>();
        // Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
/**
 * 1.hashSet调用add方法实际上是hashMap的put方法，key是hashSet中要添加的元素，value是Object类型的常量present
 * private static final Object PRESENT = new Object();
 * public boolean add(E e) {
 *         return map.put(e, PRESENT)==null;
 *     }
 *
 *
 *   2.CopyOnWriteArraySet底层其实就是CopyOnWriteArrayList
 *   private final CopyOnWriteArrayList<E> al;
 *   public CopyOnWriteArraySet() {
 *         al = new CopyOnWriteArrayList<E>();
 *     }
 *
 */
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

}
