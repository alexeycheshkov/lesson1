package com.geekbrains.lesson1_OOP.animals;

public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract void voice ();
}
