package pers.helen.javabasic.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 等所有任务执行完成
 */
public class WaitFinishedDemo2 {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Integer> list = Arrays.asList(1,2,3);
        CountDownLatch countDownLatch = new CountDownLatch(list.size());

    }
}
