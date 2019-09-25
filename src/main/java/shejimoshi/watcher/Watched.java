package shejimoshi.watcher;

/**
 * Author 范群松.
 * Date：2018/10/8
 * Time: 9:01
 */

//抽象主题角色，watched被观察
public interface Watched {
    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String str);
}
