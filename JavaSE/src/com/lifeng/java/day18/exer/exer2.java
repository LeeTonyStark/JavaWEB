package com.lifeng.java.day18.exer;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 1.分析以下需求，并用代码实现：
 * 	(1)定义一个员工类Employee，包含三个属性：姓名(String name)、年龄(int age)、工资(int salary)
 * 	(2)创建5个对象装入TreeSet，按照工资从高到底排序输出结果(工资相同，按照年龄从低到高，工资和年龄都相同，
 * 		按照姓名字典顺序排列，但是不能去重(姓名、年龄、工资都相同))
 * @author lifeng
 * @create 2022-07-13 19:37
 */
public class exer2 {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int sal = o1.getSalary() - o2.getSalary();
                int age = sal == 0 ? o1.getAge() - o2.getAge() : sal;
                int name = age == 0 ? o1.getName().compareTo(o2.getName()) : age;
                int i = name == 0 ? 1 : name;
                return i;
            }
        });
        employees.add(new Employee("小王",23,20000));
        employees.add(new Employee("小钱",25,30000));
        employees.add(new Employee("小孙",24,15000));
        employees.add(new Employee("小李",28,30000));
        employees.add(new Employee("小赵",29,40000));

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee{
    private String name;
    private int age;
    private int salary;

    public Employee() {
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }
}
