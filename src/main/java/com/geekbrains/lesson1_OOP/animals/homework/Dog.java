package com.geekbrains.lesson1_OOP.animals.homework;

public class Dog extends Animal {
    private static int countDog=0;

    public Dog(String name) {
        super(name);
        super.runLimit=500;
        super.swimLimit=10;
        countDog+=1;
    }

    public static int getCountDog() {
        return countDog;
    }


}
