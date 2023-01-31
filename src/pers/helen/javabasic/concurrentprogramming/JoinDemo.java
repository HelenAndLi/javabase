package pers.helen.javabasic.concurrentprogramming;

public class JoinDemo {

    public static void main(String[] args){
        Thread a = new Thread(()->System.out.println("thread a run."));

        Thread b = new Thread(()->{
            try{
                a.join();
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("thread b run.");
        });

        Thread c = new Thread(()->{

            try{
                b.join();
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("thread c run.");
        });
        c.start();
        b.start();
        a.start();
    }
}
