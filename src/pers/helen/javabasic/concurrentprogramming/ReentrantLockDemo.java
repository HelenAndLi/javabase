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
            System.out.println("我把它锁住啦");
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
            System.out.println("我拿到它啦");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            reentrantLock.unlock();
            System.out.println("get 解锁");
        }
    }

    public static void main(String[] args){
        new Thread(new ReentrantLockDemo()).start();
    }
}
