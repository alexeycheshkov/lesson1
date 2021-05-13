package com.geekbrains.lesson2_OOP;

public enum Month {
    JANUARY(1,31),
    FEBRUARY(2,28),
    MARCH(3,31),
    APRIL(4,31),
    MAY(5,31),
    JUNE(6,31),
    JULY(7,31),
    AUGUST(8,31),
    SEPTEMBER(9,31),
    OCTOBER(10,31),
    NOVEMBER(11,31),
    DECEMBER(12,31);

    private String name;
    private int number;
    private int days;

    Month(int number, int days) {
        this.number = number;
        this.days = days;
    }

    public int getNumber() {
        return number;
    }

    public int getDays() {
        return days;
    }
}
