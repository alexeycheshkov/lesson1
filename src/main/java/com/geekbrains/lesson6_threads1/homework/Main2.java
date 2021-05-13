package com.geekbrains.lesson6_threads1.homework;


public class Main2 {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int HALF = SIZE/2;
        float[] array = new float[SIZE];
        float[] arrayCopy = new float[HALF];
        for (int i = 0; i < SIZE; i++) {
            array[i]=1.0f;
        }

        long startTime = System.currentTimeMillis();
        System.arraycopy(array,HALF,arrayCopy,0,HALF);

        Thread checkArray1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    array[i]=(float) (array[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
                }
            }
        });

        Thread checkArray2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j=HALF; i < arrayCopy.length; i++,j++) {
                    arrayCopy[i]=(float) (arrayCopy[i]*Math.sin(0.2f+j/5)*Math.cos(0.2f+j/5)*Math.cos(0.4f+j/2));
                }
            }
        });

        checkArray1.start();
        checkArray2.start();

        try {
            checkArray1.join();
            checkArray2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrayCopy,0,array,HALF,HALF);
        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(array[0]+" "+array[9999999]);

    }
}
