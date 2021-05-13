package com.geekbrains.lesson5_collections.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Phonebook {
    private HashMap<String, TreeSet<String>> phonebook = new HashMap<>();

    public void addPerson(String lastName, String number){
        if (phonebook.containsKey(lastName)){
            phonebook.get(lastName).add(number);
        } else {
            phonebook.put(lastName, new TreeSet<>(Arrays.asList(number)));
        }
    }
    public String getNumber(String name){
        return name+" - "+phonebook.get(name);
    }
}
