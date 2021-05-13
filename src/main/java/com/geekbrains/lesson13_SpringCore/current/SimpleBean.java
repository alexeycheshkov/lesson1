package com.geekbrains.lesson13_SpringCore.current;

public class SimpleBean {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void doSomething() {
        System.out.println("Simple Bean print = " + value);
    }
}
