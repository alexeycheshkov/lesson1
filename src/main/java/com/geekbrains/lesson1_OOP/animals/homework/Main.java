package com.geekbrains.lesson1_OOP.animals.homework;

public class Main {
    public static void main(String[] args) {
        Animal animalCat1 = new Cat("Дуся");
        Animal animalCat2 = new Cat("Леська");
        Animal animalDog1 = new Dog("Бобик");
        Animal animalDog2 = new Dog("Тузик");
        Animal animalDog3 = new Dog("Полкан");
        Animal animalTiger1 = new Tiger("Король");
        Animal[] animalsArray = new Animal[]{animalCat1,animalCat2,animalDog1,animalDog2,animalDog3,animalTiger1};
        for (Animal animal : animalsArray) {
            animal.animalRun(250);
            animal.animalSwim(10);
        }
        System.out.println("Всего у нас "+ Animal.getCountAnimals()+" животных. Из них "+Cat.getCountCat()+" из семейства котов (из которых "+Tiger.getCountTiger()+" тигров), а также есть "+Dog.getCountDog()+" собак.");
    }
}
