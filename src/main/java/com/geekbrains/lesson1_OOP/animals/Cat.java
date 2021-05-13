package com.geekbrains.lesson1_OOP.animals;

public class Cat extends Animal{
    int clawsLength;
    public Cat(String name, String color, int age, int clawsLength) {
        super(name, color, age);
        this.clawsLength = clawsLength;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Cat)){
            return false;
        }
        return this.color.equals(((Cat) obj).color) && this.age == ((Cat) obj).age;
    }

    @Override
    public void voice() {
        System.out.println(name+" meow!");
    }
}
