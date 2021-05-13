package com.geekbrains.lesson5_collections.homework;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"Береза","Тополь", "Вяз", "Клен","Сосна", "Пихта", "Ольха", "Дуб", "Клен","Сосна", "Береза","Тополь","Береза" };
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String s : stringArray) {
            if (stringIntegerMap.containsKey(s)){
                stringIntegerMap.put(s,stringIntegerMap.get(s)+1);
            } else {
                stringIntegerMap.put(s,1);
            }
        }
        System.out.println(stringIntegerMap.entrySet());
        System.out.println(stringIntegerMap.keySet());
    }
}
