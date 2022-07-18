package com.lifeng.java.day10.exer;

/**
 * @author lifeng
 * @create 2022-07-02 13:04
 */
public class exer1 {

    public static void main(String[] args) {
        //测试类中调用接口playGame()方法
//        new Inter(){
//
//            @Override
//            public void playGame() {
//                System.out.println("玩游戏");
//            }
//
//        }.playGame();
//
//
//        //测试经过训练的猫和狗会不会跳高？
//        Animal animal = new Cat();
//        Cat cat = (Cat) animal;
//        cat.playGame();
//
//        Animal animal1 = new Dog();
//        Dog dog = (Dog) animal1;
//        dog.playGame();

    }

}

/**
 * 动物类
 */
//class Animal{
//    private String name;
//    private int age;
//
//    public Animal() {
//    }
//
//    public Animal(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void eat(){
//
//    }
//
//    public void sleep(){
//
//    }
//
//}
//
///**
// * 狗类
// */
//class Dog extends Animal implements Inter{
//    private String fur;//毛
//    private int leg;//腿的个数
//
//    public Dog() {
//    }
//
//    public Dog(String fur, int leg) {
//        this.fur = fur;
//        this.leg = leg;
//    }
//
//    public String getFur() {
//        return fur;
//    }
//
//    public void setFur(String fur) {
//        this.fur = fur;
//    }
//
//    public int getLeg() {
//        return leg;
//    }
//
//    public void setLeg(int leg) {
//        this.leg = leg;
//    }
//
//    @Override
//    public void eat(){
//        System.out.println("狗吃肉");
//    }
//
//    public void lookHome(){
//        System.out.println("狗看家");
//    }
//
//    @Override
//    public void playGame() {
//        System.out.println("我是狗，我也会跳高");
//    }
//}
//
///**
// * 猫类
// */
//class Cat extends Animal implements Inter{
//    private String c_fur;//毛
//    private int c_leg;//腿的个数
//
//    public Cat() {
//    }
//
//    public Cat(String c_fur, int c_leg) {
//        this.c_fur = c_fur;
//        this.c_leg = c_leg;
//    }
//
//    public String getC_fur() {
//        return c_fur;
//    }
//
//    public void setC_fur(String c_fur) {
//        this.c_fur = c_fur;
//    }
//
//    public int getC_leg() {
//        return c_leg;
//    }
//
//    public void setC_leg(int c_leg) {
//        this.c_leg = c_leg;
//    }
//
//    public void eat(){
//        System.out.println("猫吃鱼");
//    }
//
//    public void catchMouse(){
//        System.out.println("猫抓老鼠");
//    }
//
//    @Override
//    public void playGame() {
//        System.out.println("我是猫，我会跳高");
//    }
//}
//
//interface Inter{
//    void playGame();
//}
