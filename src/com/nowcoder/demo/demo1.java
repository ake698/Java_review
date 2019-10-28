package com.nowcoder.demo;

import java.util.*;

/**
 * HashMap中，使用 get(key)==null可以 判断这个Hashmap是否包含这个key
 * HashMap hashMap = new HashMap();
 * System.out.println(hashMap.get("g"));   null
 *
 * final 类不能再被声明为abastract类
 *
 * 声明为public类型的类名必须与文件名相同，默认权限的可以不同
 * 并且内部类的类名一般与文件名不同
 *·
 * Java中静态变量只能在类主体中定义，不能在方法中定义。
 * 静态变量属于类所有而不属于方法。
 */

public class demo1 {

    //取模运算，结果的符号和被除数符号一致
    public void test1(){
        int x = -3;
        int y = -10;
        System.out.println(y%x);
    }
//
//    public static void test2(){
//        byte b1=1,b2=2,b3,b6,b8;
//        final byte b4=4,b5=6,b7;
//        short a1=1,a2=2,a3;
//        a3=a1+a2;
//        b3 = (b1+b2);
//        b6 = b4 + b5;
//        b8 = b1+b4;
//        b7 = b2+b5;
//    }

    public static void demo2(){
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int count=0;
        for(int i=0;i<=(money/10);i++){
            for(int p=0;p<=((money-10*i)/5);p++){
                for(int o=0;o<=((money-10*i-5*p)/2);o++){
                    for(int u=0;u<=(money-10*i-5*p-o*2);u++){
                        if(i*10+p*5+o*2+u==money){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public void demo3(){
        String word="It's a dog!";
        String [] wordList = word.split(" ");
        if(wordList.length<=1){
            System.out.println(word);
        }else{
            StringBuffer sb = new StringBuffer();
            for(int i=wordList.length-1;i>=0;i--){
                sb.append(wordList[i]+" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void Intest(){
        Integer f1=100,f2=100,f3=127,f4=127,f5=128,f6=128;
        System.out.println(f1==f2);
        System.out.println(f3==f4);
        System.out.println(f5==f6);
    }

    public static void demo4(){
        
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        String temp = sc.nextLine();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < number ; i++) {
            temp = sc.nextLine();
            list.add(temp);
        }
        System.out.println(list);
    }


    private static int x=100;
    public static void demo5(){
        demo1 hs1=new demo1();
        hs1.x++;
        demo1  hs2=new demo1();
        hs2.x++;
        hs1=new demo1();
        hs1.x++;
        demo1.x--;
        System.out.println("x="+x);
    }


    public static boolean demo6_equals(Object a,Object b){
        if (!(a instanceof String && b instanceof String)) {
            return false;
        }
        if(((String) a).length()!=((String) b).length()){
            return false;
        }
        int index=0;
        char [] ac = ((String)a).toCharArray();
        char [] bc = ((String)b).toCharArray();
        while (((String) a).length()-1>=index){
            if(ac[index]!=bc[index]){
                return false;
            }
            index++;
        }
        return true;
    }
    public static void main(String[] args) {
//        demo4();
//        demo5();
//        System.out.println(demo6_equals("bbc","bbcd"));

        S s= new S();
        s.a();
    }
}

class P{
    public static int number=10;
    static {
        System.out.println("P is init");
    }

    public void a(){
        b();  //当运行S.a（） 方法时候 此时是调用子类中的b方法
    }
    public void b(){
        System.out.println("Base b method");
    }
}

class S extends P{
    static {
        System.out.println("S is init");
    }
    public void a(){
        super.a();
    }
    public void b(){
        System.out.println("Child b");
    }

}
