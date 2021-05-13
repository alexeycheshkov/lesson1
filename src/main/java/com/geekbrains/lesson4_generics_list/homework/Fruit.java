package com.geekbrains.lesson4_generics_list.homework;

public abstract class Fruit {
    protected String color;
    protected double oneWeight;

    public Fruit(String color, double oneWeight) {
        this.color = color;
        this.oneWeight = oneWeight;
    }

    @Override
    public String toString() {
        return "Fruit{" +this.getClass().getSimpleName()+
                ", color='" + color + '\'' +
                ", oneWeight=" + oneWeight +
                '}';
    }
}
