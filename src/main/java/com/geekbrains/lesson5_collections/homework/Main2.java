package com.geekbrains.lesson5_collections.homework;

import java.math.BigInteger;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addPerson("Cheshkov", "89198576627");
        phonebook.addPerson("Cheshkov", "89198576629");
        phonebook.addPerson("Cheshkova", "89198576628");
        System.out.println(phonebook.getNumber("Cheshkov"));
        System.out.println(phonebook.getNumber("Cheshkova"));
    }

}
