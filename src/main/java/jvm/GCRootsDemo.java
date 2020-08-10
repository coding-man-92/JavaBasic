package jvm;



/**
 * 判断垃圾的方法之一：GC Roots  根节点的可达性分析   从GC Roots对象开始遍历
 * 可作为GC Roots的四种对象：
 * 1.虚拟机栈（栈帧中的本地变量表）中引用的对象；
 * 2.方法区中类的静态属性引用的对象；
 * 3.方法区中常量引用的对象；
 * 4.本地方法栈中JNI(即一般说的Native方法）中引用的对象。
 * @author: 宋荣华
 * @date: 2020/4/10
 * @description mianshi.jvm
 */
public class GCRootsDemo {
    // 方法区中的类静态属性引用的对象
    private static GCRootsDemo gcRootsDemo;
    // 方法区中常量引用的对象
    private static final GCRootsDemo getGcRootsDemo;

    static {
        getGcRootsDemo = new GCRootsDemo();
    }

    public static void test(){
        // 虚拟机栈中引用的对象
        GCRootsDemo gcRootsDemo = new GCRootsDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        test();
    }
}
