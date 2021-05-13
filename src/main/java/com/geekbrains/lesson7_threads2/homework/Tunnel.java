package com.geekbrains.lesson7_threads2.homework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{
    private Semaphore smp;
    public Tunnel (int length){
        this.smp = new Semaphore(Main.CARS_COUNT/2);
        this.length = length;
        this.description = "Тоннель "+length+" метров.";
    }
    @Override
    public void go(Car c) {
        try {
            if (!smp.tryAcquire()){
                System.out.println(c.getName()+" ожидает этап: "+description);
                smp.acquire();
            }
            System.out.println(c.getName()+" начал этап: "+description);
            Thread.sleep(length/c.getSpeed()* 1000L);
            System.out.println(c.getName()+" закончил этап: "+description);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            smp.release();
        }
    }
/*    ArrayBlockingQueue<Car> synArray = new ArrayBlockingQueue<>(Main.CARS_COUNT/2); // Мое решение
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName()+" ожидает этап: "+description);
            synArray.put(c);
            System.out.println(c.getName()+" начал этап: "+description);
            Thread.sleep(length/c.getSpeed()* 1000L);
            System.out.println(c.getName()+" закончил этап: "+description);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            synArray.remove(c);
        }
    }*/
}
