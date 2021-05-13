package com.geekbrains.lesson1_OOP.animals.homework;

public class Cat extends Animal {
    private static int countCat=0;

    public Cat(String name) {
        super(name);
        super.runLimit=200;
        super.swimLimit=0;
        countCat+=1;
    }

    public static int getCountCat() {
        return countCat;
    }


    @Override
    public void animalSwim(int distance) {
        if (distance == 0){
            System.out.println(name+" сидит на суше, пронесло, коты ведь не умеют плвать.");
        } else System.out.println("Домашние коты не плавают, поэтому кот "+name+" утонул..");
    }
}
