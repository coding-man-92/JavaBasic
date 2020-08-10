package ref;

/**
 * @author: 宋荣华
 * @date: 2020/4/10
 * @description mianshi.ref
 */
public class StrongRefDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o1); // null
        System.out.println(o2); // 不为null
    }
}
