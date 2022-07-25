package com.lifeng.java.day26.pojo;

import java.io.Serializable;

/**
 * @author lifeng
 * @create 2022-07-25 23:03
 */
public class Employee implements Serializable {
    private String name;
    private Integer age;
    private String eid;

    public Employee() {
    }

    public Employee(String name, Integer age, String eid) {
        this.name = name;
        this.age = age;
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eid='" + eid + '\'' +
                '}';
    }
}
