package pers.helen.javabasic.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiComsumerDemo {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("a","apple");
        map.put("b","banana");
        map.put("c","carrot");
        map.forEach((s, s2)->System.out.println("key:" + s + ", value:" + s2));
        // 这俩是一个东西
        map.forEach(new BiConsumer<String, String>() {

            @Override
            public void accept(String s, String s2){
                System.out.println("key:" + s + ", value:" + s2);
            }
        });
    }
}
