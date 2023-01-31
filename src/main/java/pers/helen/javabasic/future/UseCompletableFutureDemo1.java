package pers.helen.javabasic.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @see pers.helen.javabasic.future.UseThreadPoolDemo1
 * 用CompletableFuture改造
 */
public class UseCompletableFutureDemo1 {

    public static void main(String[] args){
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Integer> list = Arrays.asList(1, 2, 3);
        for(Integer i : list){
            // 提交（异步）任务，一个参数是任务，一个参数是线程池
            CompletableFuture.supplyAsync(new Supplier<Object>() {

                @Override
                public Object get(){
                    try{
                        // 假装要忙一会儿
                        Thread.sleep(1000L);
                    }catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    return "supplier get = " + i;
                }
            }, executorService).whenCompleteAsync(new BiConsumer<Object, Throwable>() {
                // 异或获取结果，一个参数是结果，一个参数是异常信息
                // 如果想同步获取结果，就用whenComplete()，或者单独调用join()
                @Override
                public void accept(Object s, Throwable e){
                    // 获取结果
                    System.out.println(s);
                }
            });
        }

        executorService.shutdown();

        try{
            // 因为whenCompleteAsync是异步的所以要阻塞会儿才能确保拿到结果
            Thread.sleep(2000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
