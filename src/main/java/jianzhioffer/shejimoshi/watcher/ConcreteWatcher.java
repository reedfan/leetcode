package jianzhioffer.shejimoshi.watcher;

/**
 * Author 范群松.
 * Date：2018/10/8
 * Time: 9:04
 */

public class ConcreteWatcher implements Watcher {

    public void update(String str) {
        System.out.println(str);
    }
}
