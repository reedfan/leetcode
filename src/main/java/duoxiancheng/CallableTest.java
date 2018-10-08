package duoxiancheng;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author 范群松.
 * Date：2018/9/22
 * Time: 15:10
 */

public class CallableTest {
    public static void main(String[] args) throws Exception{
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        //extends Runnable, Future<V>
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        //既可以作为Runnable被线程执行
        new Thread(futureTask).start();
        //又可以作为Future得到Callable的结果
        System.out.println(futureTask.get());
    }
}
