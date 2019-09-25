package shejimoshi.singleton.st;

public class StaticClassTest {
    public static void main(String[] args) {
        StaticClass sc = StaticClass.getInstance();
        StaticClass sc1 = StaticClass.getInstance();
        System.out.println(sc == sc1);
    }
}
