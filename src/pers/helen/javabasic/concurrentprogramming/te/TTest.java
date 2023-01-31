package pers.helen.javabasic.concurrentprogramming.te;

/**
 * C，B，A 三个线程顺序启动，顺序打印 A，B，C
 * <p>
 * 题目要求：不能用sleep函数，注意考虑线程安全问题。
 */
public class TTest {

    public static void main(String[] args){

        Thread a = new Thread(()->System.out.println("thread a run."));

        Thread b = new Thread(()->{
            System.out.println("thread b run.");
        });

        Thread c = new Thread(()->{
            System.out.println("thread c run.");
        });

        try{
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
//        a.start();
//        b.start();
//        c.start();

    }
}
