package com.geekbrains.lesson2_OOP.homework;

public class Main {
    public static void main(String[] args) {
        Player [] players = {
                new Human("Alex",500,50),
                new Robot("Robocop",10000,10000),
                new Cat("Barsik",1000,10)
        } ;

        Let [] lets = {
                new Wall(40),
                new RunRoad(700)
        };

        for (Player player : players) {
            for (int i=0;i<lets.length;i++){
                if(lets[i].letGo(player)){
                    continue;
                }
                    System.out.println(player.toString()+" сходит с дистанции");
                    break;
            }
        }
    }
}
