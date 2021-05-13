package com.geekbrains.lesson1_OOP;

import com.geekbrains.lesson1_OOP.animals.Cat;
import com.geekbrains.lesson1_OOP.animals.Dog;

public class MainApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik","White", 2,1);
        Cat cat2= new Cat("Murzik","Black",6,2);
        Dog dog = new Dog("Bobik", "White", 2);
        System.out.println(dog);
        dog.voice();
        System.out.println(cat);
        cat.voice();

        System.out.println(cat.equals(cat2));


    }
}
