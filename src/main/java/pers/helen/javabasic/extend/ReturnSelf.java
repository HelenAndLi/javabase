package pers.helen.javabasic.extend;

public class ReturnSelf {

    ReturnSelf(int num){
    }

    ReturnSelf(String str){
    }

    ReturnSelf(int num, String str){
        /**
         * 就是说一个构造函数里，调用另一个构造函数必须放在第一行，而且只能有一个
         */
        //        num++;
        this(str);
        //        this(num);
    }

    int num;

    ReturnSelf incr(){
        num++;
        return this;
    }

    private void print(){
        System.out.println("num = " + num);
    }

    public static void main(String[] args){
        ReturnSelf rs = new ReturnSelf("hello");
        rs.incr().incr().incr().print();
    }
}
