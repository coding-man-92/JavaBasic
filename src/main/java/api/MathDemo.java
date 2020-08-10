package api;

/**
 * @author: 宋荣华
 * @date: 2020/5/4
 * @description api
 */
public class MathDemo {
    public static void main(String[] args) {
        // 返回参数绝对值
        System.out.println(Math.abs(-10));
        // 返回大于等于参数的最小值(11)
        System.out.println(Math.ceil(10.3));
        // 返回小于等于参数的最大值
        System.out.println(Math.floor(-2.3));
        // 返回一个伪随机数
        System.out.println(Math.random());
        // 返回参数的四舍五入值
        System.out.println(Math.round(5.4));
        // 返回a的b次幂
        System.out.println(Math.pow(2, 3));

        System.out.println(Math.min(10, 20));

        System.out.println(Math.max(10, 20));

    }
}
