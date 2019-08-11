package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConTest {

    final Lock lock = new ReentrantLock();
    /*
    一个Condition的实例必须与一个Lock绑定，因此Condition一般都是作为Lock的内部实现。
     */
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConTest conTest = new ConTest();
        conTest.new Consumer().start();
        conTest.new Producer().start();

    }


    class Consumer extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("我在等一个新信号"+this.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号"+this.currentThread().getName());
                lock.unlock();
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁"+this.currentThread().getName());
                condition.signalAll();
                System.out.println("我发出了一个信号："+this.currentThread().getName());
            } finally{
                lock.unlock();
            }
        }

    }

}
