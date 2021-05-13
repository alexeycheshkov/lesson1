package com.geekbrains.lesson9.homework;

@Table(title = "People")
public class Person {
    @Column
    String name;
    @Column
    int age;
    @Column
    int salary;

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @ColumnMethod
    public int getAge() {
        return age;
    }
    @ColumnMethod
    public int getSalary() {
        return salary;
    }
    @ColumnMethod
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}
