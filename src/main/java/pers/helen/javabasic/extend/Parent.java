package pers.helen.javabasic.extend;

public class Parent {

    public void say(){
        System.out.println("parent say.");
        this.hello();
    }

    public void hello(){
        System.out.println("parent hello.");
    }
}
