package com.geekbrains.lesson9.reflectionAPI;

public class Person {
    private String name;
    private int age;
    private int salary;

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

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

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @MyAnnotation(priority = 1)
    private boolean compareTo (Person person){
        return this.getAge()< person.getAge();
    }

}
