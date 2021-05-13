package com.geekbrains.lesson4_generics_list.homework;

import java.util.ArrayList;
import java.util.List;

public class Box_old<T extends Fruit> {
/*
    private int id;
    private double weight;
    private double maxWeight;
    private List<T> boxOfFruits = new ArrayList<>();

    public void replaceBox(int id){

        Box_old<T> newBox = new Box_old(id, getMaxWeight());
        this.setWeight(getWeight());
        newBox.setWeight(this.getWeight());
        newBox.boxOfFruits.addAll(this.boxOfFruits);
    }

    public boolean compareTo(Box_old<? extends Fruit> anotherBox){
        return Math.abs(this.weight-anotherBox.weight)<0.00000000001;
    }

    public Box_old(int id, double maxWeight) {
        this.id = id;
        this.weight = 0;
        this.maxWeight = maxWeight;
    }

    public List<T> getBoxOfFruits() {
        return boxOfFruits;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setBoxOfFruits(T fruit) {
        boxOfFruits.add(fruit);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
*/

}
