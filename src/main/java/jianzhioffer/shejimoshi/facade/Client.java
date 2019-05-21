package jianzhioffer.shejimoshi.facade;

import jianzhioffer.shejimoshi.facade.facade.Computer;

/**
 * https://www.cnblogs.com/lthIU/p/5860607.html
 */

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        System.out.println("==============");
        computer.shutdown();
    }
}
