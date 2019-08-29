package leetcode.shejimoshi.singleton;


/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 22:28
 */

public class Singleton2 {
    private Singleton2(){

    }

    private static Singleton2 singleton2 = null;
    public static Singleton2 getSingleton2() {
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
