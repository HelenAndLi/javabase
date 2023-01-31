package pers.helen.javabasic.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用线程池处理任务
 */
public class UseThreadPoolDemo1 {

    public static void main(String[] args){
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Future<String>> futures = new ArrayList<>();
        for(Integer i : list){
            // 提交任务
            Future<String> future = executorService.submit(new Callable<String>() {

                @Override
                public String call() throws Exception{
                    // 假装在忙
                    Thread.sleep(1000L);
                    return "call end i=" + i;
                }
            });
            futures.add(future);
        }
        // 获取结果
        try{
            for(Future<String> f : futures){
                // 这个get()可是会阻塞当前线程的，一直到结果返回，影响性能
                System.out.println(f.get());
            }
        }catch(ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
        // 关闭线程池
        executorService.shutdown();

    }
}
