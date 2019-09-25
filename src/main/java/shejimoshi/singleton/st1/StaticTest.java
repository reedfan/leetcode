package shejimoshi.singleton.st1;

/**
 * 是一种变种的恶汉模式
 *
 */

public class StaticTest {

    private static StaticTest staticTest = null;

    private StaticTest(){

    }
    static {
        System.out.println("Singleton--我在被调用的时候加载，而且只加载一次");
        staticTest = new StaticTest();
    }

    public static StaticTest getInstance(){
        return staticTest;
    }


}
