package leetcode.shejimoshi.singleton;

/**
 * Author 范群松.
 * Date：2018/8/26
 * Time: 17:13
 */

public class Singleton {

    private Singleton(){ }
    private static Singleton singleton = null;
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }

            }
        }
        return singleton;
    }




}
