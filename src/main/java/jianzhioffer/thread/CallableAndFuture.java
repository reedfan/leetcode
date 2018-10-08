package jianzhioffer.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author 范群松.
 * Date：2018/8/21
 * Time: 15:14
 */

public class CallableAndFuture {

    public static void main(String[] args) throws Exception{
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<Integer> future = threadPool.submit(new Callable<Integer>(){
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
        Thread.sleep(500);
        System.out.println(future.get());
    }

}
