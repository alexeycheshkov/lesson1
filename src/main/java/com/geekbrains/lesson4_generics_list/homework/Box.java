package com.geekbrains.lesson4_generics_list.homework;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private double weight;
    private double maxWeight;
    private List<T> boxOfFruits = new ArrayList<>();

    public boolean compareTo(Box<? extends Fruit> anotherBox){
        return Math.abs(this.weight-anotherBox.weight)<0.00000000001;
    }

    public void replaceFruits (Box<? super T> another){
        if(this==another){
            return;
        }
        if (another.maxWeight>=this.maxWeight) {
            another.boxOfFruits.addAll(this.boxOfFruits);
            another.weight += this.weight;
            this.boxOfFruits.clear();
            this.weight = 0;
            System.out.println("Фрукты пересыпаны в другую коробку.");
        } else {
            System.out.println("Фрукты нельзя пересыпать в меньшую коробку.");
        }
    }

    public void add(T fruit){
        if ((this.weight + fruit.oneWeight)<=this.maxWeight){
            this.boxOfFruits.add(fruit);
            this.weight += fruit.oneWeight;
            System.out.println("Фрукт добавлен в коробку.");
        } else {
            System.out.println("Коробка не вмещает столько фруктов.");
        }
    }

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getWeight() {
        return weight;
    }

    public List<T> getBoxOfFruits() {
        return boxOfFruits;
    }

}
