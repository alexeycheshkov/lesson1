package com.geekbrains.lesson8_streamAPI.homework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"A","B","C","D","E","F","G","A","A","B"};
        String result = Arrays.stream(stringArray).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(value -> value.getValue()))
                .get().getKey();
        System.out.println(result);

        Person[] people = new Person[]{new Person("Alex",28,50000), new Person("Vicky",30,25000), new Person("Den", 29,20000), new Person("Dima",28,45000)};
        System.out.println(Arrays.stream(people).mapToDouble(Person::getSalary).average().getAsDouble()); //Мое решение

        Arrays.stream(people).sorted((Comparator.comparingInt(Person::getAge))).skip(people.length-2).forEach(System.out::println); //Мое решение
        System.out.println(Arrays.stream(people).sorted(((o1, o2) -> o2.getAge()- o1.getAge())).limit(2).map(Person::getName).collect(Collectors.joining(", ", 2 + " самых старших сотрудника зовут: ",".")));
    }

}
