package jianzhioffer.shejimoshi.decorator;

public class Decorator implements House {
    private House house;

    public Decorator(House house) {
        this.house = house;
    }
    @Override
    public void output() {
        System.out.println("这是针对房子的前段装饰增强");
        house.output();
        System.out.println("这是针对房子的后段装饰增强");
    }
}
