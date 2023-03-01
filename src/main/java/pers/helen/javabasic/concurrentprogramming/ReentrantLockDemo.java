package pers.helen.javabasic.concurrentprogramming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {

    Lock reentrantLock = new ReentrantLock();

    @Override
    public void run(){
        set();
    }

    public void set(){
        try{
            reentrantLock.lock();
            System.out.println("锁住");
            get();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            reentrantLock.unlock();
            System.out.println("set 解锁");
        }
    }

    public void get(){
        try{
            reentrantLock.lock();
            System.out.println("获取到");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            reentrantLock.unlock();
            System.out.println("get 解锁");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //        new Thread(new ReentrantLockDemo()).start();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("main thread lock!");
        for(int i = 0; i < 50; i++){
            new Thread(()->{
                lock.lock();
                System.out.println(Thread.currentThread().getId() + " acquire lock.");
                lock.unlock();
            }).start();
            Thread.sleep(100);
        }
        lock.unlock();
        System.out.println("main thread unlock!");
    }
}
