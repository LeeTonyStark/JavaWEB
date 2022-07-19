package com.lifeng.java.day10.exer;

/**
 * @author lifeng
 * @create 2022-07-02 13:47
 */
public class exer3 {

    public static void main(String[] args) {
        //定义一个饲养员类，喂养三次小动物
        Feeder feeder1 = new Feeder();

        Dog dog = new Dog();
        Sheep sheep = new Sheep();
        Frog frog = new Frog();

        feeder1.feeding(dog);
        System.out.println();
        feeder1.feeding(sheep);
        System.out.println();
        feeder1.feeding(frog);
    }

}

/**
 * 动物类
 */
class Animal{
    private int age;

    public Animal() {
    }

    public Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //喝水
    public void drink(){}

    //吃东西
    public void eat(){}

    //游泳
    public void swim() {
    }
}

/**
 * 游泳接口
 */
interface Swiming{
    //游泳方法
    void swim();
}

/**
 * 狗类
 */
class Dog extends Animal implements Swiming{

    @Override
    public void drink() {
        System.out.println("喝水");
    }

    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗会狗刨游泳");
    }
}

/**
 * 羊类
 */
class Sheep extends Animal{

    @Override
    public void drink() {
        System.out.println("喝水");
    }

    @Override
    public void eat() {
        System.out.println("羊吃草");
    }
}

/**
 * 青蛙类
 */
class Frog extends Animal implements Swiming{

    @Override
    public void drink() {
        System.out.println("喝水");
    }

    @Override
    public void eat() {
        System.out.println("青蛙吃小虫");
    }


    @Override
    public void swim() {
        System.out.println("青蛙会蛙泳");
    }
}

/**
 * 饲养员类
 */
class Feeder{
    Animal animal;//定义一个动物类，饲养员要喂养动物
    public Animal feeding(Animal animal){
        animal.drink();
        animal.eat();
        animal.swim();
        return animal;
    }
}