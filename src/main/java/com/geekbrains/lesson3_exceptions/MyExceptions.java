package com.geekbrains.lesson3_exceptions;

public class MyExceptions extends RuntimeException{

    private int row;
    private int column;
    private int value;

    public MyExceptions(int row, int column, int[][] array) {
        super("Invalid data: ["+row+", "+column+"] "+array[row][column]);
        this.row = row;
        this.column = column;
        this.value = array[row][column];
    }
}
