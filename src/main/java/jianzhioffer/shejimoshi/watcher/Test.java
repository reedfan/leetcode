package jianzhioffer.shejimoshi.watcher;

import java.util.UUID;

/**
 * Author 范群松.
 * Date：2018/10/8
 * Time: 9:12
 */

public class Test {

    public static void main(String[] args) {
        Watched girl = new ConcreteWatched();
        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        girl.addWatcher(watcher1);
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);

        girl.notifyWatchers("update");
    }


}
