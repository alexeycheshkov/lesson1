package com.geekbrains.lesson1_OOP.animals.homework;

public class Tiger extends Cat {
    private static int countTiger=0;

    public static int getCountTiger() {
        return countTiger;
    }

    public Tiger(String name) {
        super(name);
        super.runLimit=2000;
        super.swimLimit=500;
        countTiger+=1;
    }

    @Override
    public void animalSwim(int distance) {
        if (distance == 0){
            System.out.println(name+" сидит на суше, отдыхает.");
        } else if (distance<=swimLimit){
            System.out.println(name+" проплыл "+distance+" метров!");
        } else {
            System.out.println(name+" устал, проплыл всего "+swimLimit+" метров и утонул..");
        }
    }
}
