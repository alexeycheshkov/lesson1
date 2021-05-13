package com.geekbrains.lesson1_OOP.animals;

public class Dog extends Animal {

    public Dog() {
    }

    @Override
    public void voice() {
        System.out.println(name+" wuf!");
    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
}
