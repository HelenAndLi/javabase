package pers.helen.javabasic.concurrentprogramming;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException{
        System.out.println("𠮷".length());
        System.out.println("彐".length());
        System.out.println("好".length());
        Thread a = new Thread(()->{
            System.out.println("donothing.");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        a.start();
        a.interrupt();



    }
}
