package com.nowcoder.demo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LambdaTest {

    //对于list的遍历
    public static void demo1(){
        List<String> list = Arrays.asList("jack","tom","jerry","logic");
        list.forEach(n-> System.out.println(n));
        System.out.println("------------------------");
        list.forEach(System.out::println);
        System.out.println("----------filter--------------");
        list.forEach(str->{
            if(str.startsWith("j")) System.out.println(str);
        });
        System.out.println("------filter2-----------------------");
        list.stream().filter(str->str.contains("o")).forEach(str-> System.out.println(str));
    }

    //Map遍历
    public static void demo2(){
        Map<String,Integer> map = new HashMap<>();
        map.put("jerry",1);
        map.put("tom",2);
        map.put("rose",6);
        //普通方式
        for (Map.Entry<String,Integer>entry:map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println("---------------------------------------");
        map.forEach((key,value)-> System.out.println(key+" : "+value));
    }



    public static void main(String[] args) {
//        demo1();//对于list的遍历
        demo2();//对于字典的遍历
    }

}
