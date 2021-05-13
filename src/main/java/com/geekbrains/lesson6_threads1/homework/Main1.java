package com.geekbrains.lesson6_threads1.homework;

public class Main1 {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int HALF = SIZE/2;
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i]=1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i]=(float) (array[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(array[0]+" "+array[9999999]);
    }
}
