package pers.helen.javabasic.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @see UseThreadPoolDemo1
 * 用CompletableFuture改造
 */
public class UseCompletableFutureDemo11 {

    public static void main(String[] args){
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Integer> list = Arrays.asList(1, 2, 3);

        List<Object> result = list.stream().map(i-> CompletableFuture.supplyAsync(new Supplier<Object>() {

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
        }, executorService)).map(CompletableFuture::join).collect(Collectors.toList());

        executorService.shutdown();

        System.out.println(result);
    }
}
