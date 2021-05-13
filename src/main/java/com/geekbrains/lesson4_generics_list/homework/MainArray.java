package com.geekbrains.lesson4_generics_list.homework;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) {
        Integer[] numberArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        String[] stringArray = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        Object[] objArray = new Object[]{numberArray,stringArray};
        System.out.println(arrayToArrayList(stringArray));

    }
    public static <T> T[] changeElement(T[] array, int x1, int x2){
        if (x1> array.length-1 || x2> array.length-1){
            throw new ArrayIndexOutOfBoundsException("Такой индекс отсутствует в массиве.");
        }
        T temp;
        for (int i = 0; i < array.length; i++) {
            if (i == x1){
                temp = array[i];
                array[i] = array[x2];
                array[x2] = temp;
                break;
            }
        }
        return array;
    }
    public static <T> ArrayList<T> arrayToArrayList (T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
