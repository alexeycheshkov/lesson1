package com.geekbrains.lesson2_OOP.homework;

public class Human implements Player{
    private String name;
    private int distanceLimit;
    private int jumpHeightLimit;

    public Human (String name, int distanceLimit, int jumpHeightLimit) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.jumpHeightLimit = jumpHeightLimit;
    }
/*    @Override
    public boolean go(Let let){
        if (let instanceof Wall){
            return jump((Wall) let);
        } else if(let instanceof RunRoad){
            return run((RunRoad) let);
        } else return false;
    }*/

    @Override
    public String toString() {
        return name;
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

    public String getName() {
        return name;
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
