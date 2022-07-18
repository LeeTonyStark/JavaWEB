package com.lifeng.java.day11.demo;

import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-04 11:31
 */
public class demo1 {

    public static void main(String[] args) {
        Dog dog = new Dog("旺财","公",10,"啃骨头");
        System.out.println(dog);
    }

}

class Dog{
    private String name;
    private String sex;
    private int age;
    private String likeEat;

    public Dog() {
    }

    public Dog(String name, String sex, int age, String likeEat) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.likeEat = likeEat;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", likeEat='" + likeEat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Dog)) return false;
//        Dog dog = (Dog) o;
//        return age == dog.age && Objects.equals(name, dog.name) && Objects.equals(sex, dog.sex) && Objects.equals(likeEat, dog.likeEat);

        //非空判断
        if (o == null){
            return false;
        }

        //判断类型是否为狗
        if (!(o instanceof Dog)){
            return false;
        }
        //类型转换
        Dog dog = (Dog)o;

        return age == dog.age && Objects.equals(name, dog.name) && Objects.equals(sex, dog.sex) && Objects.equals(likeEat, dog.likeEat);


    }


}

class Cat{
    private String name;
    private String sex;
    private int age;
    private String likeEat;

    public Cat() {
    }

    public Cat(String name, String sex, int age, String likeEat) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.likeEat = likeEat;
    }


}