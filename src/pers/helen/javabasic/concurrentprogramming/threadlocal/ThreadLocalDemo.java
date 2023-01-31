package pers.helen.javabasic.concurrentprogramming.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalDemo {
    private static ThreadLocal threadLocal = new ThreadLocal();
    private static List<User> list = new ArrayList<>();

    public static void main(String[] args){
        new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            User user = new User();
            user.setId(12);
            user.setRealname("k9999");
            threadLocal.set(user);
            list.add(user);
            System.out.println("====== thread-1 ======");
            System.out.println("thread-1 add user to threadLocal & list.");
        }).start();

        new Thread(()->{
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("====== thread-2 ======");
            System.out.println("thread-2 get user.");
            System.out.println("threadLocal get: "+threadLocal.get());
            System.out.println("list get: "+list.get(0));
        }).start();
    }
}

class User {
    private long id;
    private String realname;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getRealname(){
        return realname;
    }

    public void setRealname(String realname){
        this.realname = realname;
    }

    @Override
    public String toString(){
        return "User, [id="+getId()+", realname:"+getRealname()+"]";
    }
}
