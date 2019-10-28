package com.nowcoder.demo;

public class Singleton {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        car car1 = carFactory.getCar("Jeep");
        car1.make();
    }
}

class Singleton1{
    //饿汉模式
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return singleton1;
    }
}

class Singleton2{
    //饿汉模式
    private static Singleton2 singleton2 = null;
    private Singleton2(){}
    public static Singleton2 getInstance2(){
        if (singleton2==null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}


interface car{
    void make();
}
class Jeep implements car{
    @Override
    public void make() {
        System.out.println("make Jeep");
    }
}
class RaceCar implements car{
    @Override
    public void make() {
        System.out.println("make RaceCar");
    }
}
class SportsCar implements car{
    @Override
    public void make() {
        System.out.println("make SportCar");
    }
}

class CarFactory{
    public car getCar(String carName){
        if(carName == null){
            return null;
        }
        if(carName.equalsIgnoreCase("JEEP"))return new Jeep();
        else if(carName.equalsIgnoreCase("RACECAR"))return new RaceCar();
        else if(carName.equalsIgnoreCase("SPORTCAR"))return new SportsCar();
        return null;
    }
}