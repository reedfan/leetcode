package leetcode.shejimoshi.singleton.st;

/**
 * https://blog.csdn.net/mnb65482/article/details/80458571
 *
 * 1.外部类加载时并不需要立即加载内部类，内部类不被加载则不去加载INSTANCE，故不占内存
 * 2.
 */

public class StaticClass {
    private StaticClass(){};
    private static class StaticClassSc{
        private static StaticClass staticClassSc = new StaticClass();
    }

    public static StaticClass getInstance(){
        return StaticClassSc.staticClassSc;
    }
}
