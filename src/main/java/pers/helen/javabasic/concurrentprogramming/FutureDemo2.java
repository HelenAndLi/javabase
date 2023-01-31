package pers.helen.javabasic.concurrentprogramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        Callable r = ()->{
            // do something
            long t = System.currentTimeMillis();
            while(true){
                if(System.currentTimeMillis() - t > 3000){
                    break;
                }
            }
            //            Thread.sleep(1000);
            System.out.println("runnable run...");
            return "aha";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(r);
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }
        System.out.println(future.get());
    }
}
