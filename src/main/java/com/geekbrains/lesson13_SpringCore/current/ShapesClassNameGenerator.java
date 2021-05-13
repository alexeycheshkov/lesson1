package com.geekbrains.lesson13_SpringCore.current;

public class ShapesClassNameGenerator implements ClassNameGenerator {
    public String generateClassName() {
        String[] names = {"Square", "Circle", "Ellipse", "Triangle"};
        return names[(int) (Math.random() * 4)];
    }
}
