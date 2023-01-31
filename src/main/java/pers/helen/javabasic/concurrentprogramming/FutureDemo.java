package pers.helen.javabasic.concurrentprogramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        Callable r = ()->{
            // do something
            long t = System.currentTimeMillis();
            while(true){
                if(System.currentTimeMillis()-t>3000){
                    break;
                }
            }
//            Thread.sleep(1000);
            System.out.println("runnable run...");
            return "aha";
        };
        FutureTask futureTask = new FutureTask(r);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
}
