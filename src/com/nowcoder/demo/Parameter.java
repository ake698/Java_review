package com.nowcoder.demo;

public class Parameter {


    public static void main(String[] args) {
        Animal dog = new Animal("dog1");
        System.out.println(dog.animal);
        newFunc(dog);
        System.out.println(dog.animal);


    }

    public static void newFunc(Animal animal){
        System.out.println("---------Func--------");
        System.out.println(animal.animal);
        animal.animal = "dog2";
        System.out.println(animal.animal);
        System.out.println("---------FuncDone----------");
    }
}

class Animal{
    String animal;
    Animal(String animal){
        this.animal = animal;
    }

}
