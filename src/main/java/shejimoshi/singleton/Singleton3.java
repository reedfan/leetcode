package shejimoshi.singleton;

/**
 * Author 范群松.
 * Date：2018/8/21
 * Time: 20:40
 */

public class Singleton3 {
    private Singleton3(){ }
    private static Singleton3 singleton3 = null;
    public Singleton3 getinstance(){
        if(singleton3 == null){
            synchronized (Singleton3.class){
                if(singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
