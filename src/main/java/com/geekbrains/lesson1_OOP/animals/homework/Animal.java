package com.geekbrains.lesson1_OOP.animals.homework;

public abstract class Animal {
    protected int runLimit;
    protected int swimLimit;
    protected String name;
    private static int countAnimals = 0;

    public Animal(String name) {
        this.name = name;
        countAnimals+=1;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }


    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                '}';
    }

    public void animalRun (int distance){
        if (distance == 0){
            System.out.println(name+" сидит на месте, отдыхает.");
        } else if (distance<=runLimit){
            System.out.println(name+" пробежал "+distance+" метров!");
        } else {
            System.out.println(name + " устал и пробежал всего " + runLimit + " метров..");
        }
    }
    public void animalSwim (int distance){
        if (distance == 0){
            System.out.println(name+" сидит на суше, отдыхает.");
        } else if (distance<=swimLimit){
            System.out.println(name+" проплыл "+distance+" метров!");
        } else {
            System.out.println(name+" устал, проплыл всего "+swimLimit+" метров и утонул..");
        }
    }

}
