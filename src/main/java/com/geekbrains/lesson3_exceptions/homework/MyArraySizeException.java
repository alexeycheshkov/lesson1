package com.geekbrains.lesson3_exceptions.homework;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message) {
        super(message);
    }
}
