package pers.helen.javabasic.concurrentprogramming;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ThreadLocalDemo {

    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    public void add(){
        THREAD_LOCAL.set(1);
        // do something ...
        Integer integer = THREAD_LOCAL.get();
    }

    public static void main(String[] args){
        Object object = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object);
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
        object = null;
        System.gc();
        System.out.println(weakReference.get());

        InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set(6);
        System.out.println("父线程获取数据：" + threadLocal.get());

        new Thread(() -> {
            System.out.println("子线程获取数据：" + threadLocal.get());
        }).start();
    }
}
