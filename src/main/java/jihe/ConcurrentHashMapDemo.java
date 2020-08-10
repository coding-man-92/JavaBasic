package jihe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 宋荣华
 * @date: 2020/5/12
 * @description jihe
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("rh","ronghua");
    }

}
