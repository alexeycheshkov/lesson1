package com.geekbrains.lesson7_threads2.homework;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT=10;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT+1);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ>>>ПОДГОТОВКА К ГОНКЕ!");
        Race race = new Race(new Road(100),new Tunnel(80),new Road(150));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race,20+(int) (Math.random()*15),cyclicBarrier);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cyclicBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ>>>START!!!");
            cyclicBarrier.await();
            Car.endCounter.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ>>>ГОНКА ОКОНЧЕНА!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
