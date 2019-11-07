package com.nowcoder.demo;

import java.util.*;

class Man implements Comparable<Man>{
    int id;
    int age;
    int salary;

    @Override
    public int compareTo(Man o) {
        return o.getAge()>this.age?-1:1;  // >大于的时候 为-1  则升序排列  否则为降序
    }


    Man(){}

    Man(int id, int age, int salary){
        this.id = id;
        this.age = age;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}

public class SortBySystem {

    public static void listSort1(){
        List<Man> list = new ArrayList();
        list.add(new Man(1,10,400));
        list.add(new Man(2,16,200));
        list.add(new Man(3,11,300));
        Man man = new Man();
        Collections.sort(list);
        list.forEach(m-> System.out.println(m.toString()));
    }

    public static void listSort2(){
        List<Integer> list = new ArrayList();
        list.add(6);
        list.add(8);
        list.add(1);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;  //降序    o1-o2 则为升序
            }
        });
        list.forEach(m -> System.out.println(m));
    }

    public static void listSort3(){
        int a [] = {1,3,6,7,10,66,4};
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        listSort1();
//        listSort2();
        listSort3();
    }
}
