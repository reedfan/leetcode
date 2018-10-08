package jianzhioffer.shejimoshi.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 范群松.
 * Date：2018/10/8
 * Time: 9:06
 */

public class ConcreteWatched implements Watched {
    private List<Watcher> list = new ArrayList<Watcher>();

    public ConcreteWatched() {
        super();
    }

    public void addWatcher(Watcher watcher) {
        list.add(watcher);

    }

    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);

    }

    public void notifyWatchers(String str) {
        for(Watcher watcher:list){
            watcher.update(str);
        }

    }
}
