package com.geekbrains.lesson2_OOP.homework;

public class Cat implements Player{
    private String name;
    private int distanceLimit;
    private int jumpHeightLimit;

    public Cat(String name, int distanceLimit, int jumpHeightLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.jumpHeightLimit = jumpHeightLimit;
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }


    @Override
    public boolean jump(Wall wall) {
        if (wall.getWallHeight()<=jumpHeightLimit){
            System.out.println(name+" перепрыгнул эту стену.");
            return true;
        } else {
            System.out.println(name+" не может преодолеть это препятствие.");
            return false;}
    }

    @Override
    public boolean run(RunRoad runRoad) {
        if (runRoad.getRoadDistance()<=distanceLimit){
            System.out.println(name+" пробежал это расстояние.");
            return true;
        } else {
            System.out.println(name+" не может преодолеть это расстояние.");
            return false;}
    }
}
