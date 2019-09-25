package shejimoshi.singleton;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 22:19
 */

public class Singleton1 {

    private Singleton1(){

    }
    private static final Singleton1 singleton = new Singleton1();
    public static Singleton1 getSingleton(){
        return singleton;
    }


}
