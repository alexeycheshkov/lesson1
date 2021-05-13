package com.geekbrains.lesson7_threads2.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable{
    public static CountDownLatch endCounter = new CountDownLatch(Main.CARS_COUNT);
    private static int CARS_COUNT;
    static {
        CARS_COUNT=0;
    }

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;
    private static AtomicBoolean isWin = new AtomicBoolean(false);


    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #"+ ++CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        long startTime = 0;
        try {
            System.out.println(this.name+" готовится к гонке.");
            Thread.sleep(500+(int)(Math.random()*500));
            System.out.println(this.name+" готов к гонке.");
            cyclicBarrier.await();
            cyclicBarrier.await();
            startTime = System.currentTimeMillis();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        endCounter.countDown();

        if (!isWin.getAndSet(true)){
            System.out.println(this.name+" победил за "+(System.currentTimeMillis()-startTime)/1000+" секунд и "+(System.currentTimeMillis()-startTime)%1000+" миллисекунд.");
        }
/*        if (endCounter.getCount()==Main.CARS_COUNT-1){
        }*/
    }
}
