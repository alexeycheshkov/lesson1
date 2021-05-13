package com.geekbrains.lesson4_generics_list;

public class Main {
    public static void main(String[] args) {
        BoxWithNumbers<Integer> intBox = new BoxWithNumbers<>(1,2,3,4,5);
        BoxWithNumbers<Integer> intBox2 = new BoxWithNumbers<>(1,2,3,4,5);
        System.out.println(intBox.average());
        System.out.println(intBox.compareAvg(intBox2));
    }
}
