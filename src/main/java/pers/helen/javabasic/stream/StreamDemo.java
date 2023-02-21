package pers.helen.javabasic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 7);
        Stream<Integer> stream = list.stream();
        // filter，按照指定条件过滤
        stream.filter(i->i < 3).forEach(a->System.out.print(a + ", "));
        System.out.println();
        // distinct，去重
        stream = list.stream();
        stream.distinct().forEach(a->System.out.print(a + ", "));
        System.out.println();
        // limit，取n个元素
        stream = list.stream();
        stream.limit(5).forEach(a->System.out.print(a + ", "));
        System.out.println();
        // skip，跳过n个元素
        stream = list.stream();
        stream.skip(3).forEach(a->System.out.print(a + ", "));
        System.out.println();
        // map，映射
        List<String> strList = Arrays.asList("Hello lee", "Hello helen");
        Stream<String> strStream = strList.stream();
        strStream.map(String::toUpperCase).forEach(a->System.out.print(a + ", "));
        System.out.println();
        //flatMap
        //allMatch
        strStream = strList.stream();
        System.out.println(strStream.allMatch(s->s.contains("lee")));
        //anyMatch
        strStream = strList.stream();
        System.out.println(strStream.anyMatch(s->s.contains("lee")));
        //noneMatch
        strStream = strList.stream();
        System.out.println(strStream.noneMatch(s->s.contains("lee")));
        // count
        strStream = strList.stream();
        System.out.println(strStream.count());
        // findFirst
        stream = list.stream();
        System.out.println(stream.filter(i->i > 2).findFirst());
        // findAny
        stream = list.stream();
        System.out.println(stream.filter(i->i > 2).findAny());
        // reduce
        stream = list.stream();
        System.out.println(stream.reduce(Integer::sum));
        stream = list.stream();
        System.out.println(stream.reduce(Integer::max));
        stream = list.stream();
        System.out.println(stream.reduce(Integer::min));
        // max、min
        stream = list.stream();
        System.out.println(stream.max((a, b)->b - a));
        stream = list.stream();
        System.out.println(stream.max((a, b)->a - b));
        stream = list.stream();
        System.out.println(stream.min((a, b)->b - a));
        stream = list.stream();
        System.out.println(stream.min((a, b)->a - b));

    }
}
