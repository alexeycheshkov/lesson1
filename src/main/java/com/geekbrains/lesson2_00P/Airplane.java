package com.geekbrains.lesson2_OOP;

public class Airplane implements Flyable{
    @Override
    public void fly() {
        System.out.println("Самолет летит.");
    }
}
