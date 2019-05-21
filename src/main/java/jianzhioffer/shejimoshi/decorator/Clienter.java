package jianzhioffer.shejimoshi.decorator;

public class Clienter {
    public static void main(String[] args) {
        House reedHouse = new ReedHouse();
        House decorator = new Decorator(reedHouse);
        decorator.output();
    }
}
