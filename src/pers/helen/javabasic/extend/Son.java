package pers.helen.javabasic.extend;

import java.lang.reflect.InvocationTargetException;

public class Son extends Parent {

    @Override
    public void say(){
        super.say();
        System.out.println("son say.");
    }

    @Override
    public void hello(){
        System.out.println("son hello.");
    }

    public static void main(String[] args){
        try{
            Class cl = Class.forName("pers.helen.javabasic.extend.Parent");
            Object obj = cl.getDeclaredConstructor().newInstance();
        }catch(ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
               InvocationTargetException e){
            e.printStackTrace();
        }


        new Son().say();
    }
}
