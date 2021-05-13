package com.geekbrains.lesson4_generics_list.homework;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox= new Box<>(1.5);
        Box<Orange> orangeBox = new Box<>(2);
        Box<Apple> appleBox2 = new Box<>(3);
        Box<Fruit> fruitBox = new Box<>(2.7);
        Apple apple1 = new Apple("Red",0.5);
        Apple apple2 = new Apple("Green",0.9);
        Orange orange1 = new Orange(1.4);
        Orange orange2 = new Orange(0.9);
        appleBox.add(apple1);
        appleBox.add(apple2);
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        appleBox.replaceFruits(appleBox2);
        orangeBox.replaceFruits(fruitBox);
        appleBox2.replaceFruits(fruitBox);
        System.out.println(appleBox.compareTo(orangeBox));
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox.getBoxOfFruits().toString());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.getBoxOfFruits().toString());
        System.out.println(appleBox2.getWeight());
        System.out.println(appleBox2.getBoxOfFruits().toString());
        System.out.println(fruitBox.getWeight());
        System.out.println(fruitBox.getBoxOfFruits().toString());
    }
}
