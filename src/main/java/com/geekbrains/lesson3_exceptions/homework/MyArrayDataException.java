package com.geekbrains.lesson3_exceptions.homework;

public class MyArrayDataException extends RuntimeException{
    private int row;
    private int column;

    public MyArrayDataException(int row, int column, String array) {
        super("Ошибка данных в ячейке массива - ["+row+","+column+"]:"+array);
        this.row = row;
        this.column = column;
    }
}
