package jianzhioffer.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

/**
 * Author 范群松.
 * Date：2018/8/21
 * Time: 15:05
 * callable和future，一个产生结果，一个拿到结果
 */

public class CallableAndFuture1 {

    public static void main(String[] args) throws Exception{
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }



}
