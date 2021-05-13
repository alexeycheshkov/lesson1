package com.geekbrains.lesson13_SpringCore.current;

public class AnimalsClassNameGenerator implements ClassNameGenerator {
    public String generateClassName() {
        String[] names = {"Cat", "Dog", "Horse", "Bull"};
        return names[(int) (Math.random() * 4)];
    }
}
