package com.geekbrains.lesson8_streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers =new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> out = integers.stream()
                .filter((n)->n%2==0)
                .collect(Collectors.toList());
        System.out.println(out);

        integers.stream()
                .filter((n)->n%2==1)
                .forEach(n-> System.out.println(n));

        Stream.of("AAA","a","AAAAAAA").map(s -> s.length()).forEach(System.out::println);
        Stream.of("AAA","a","AAAAAAA").map(String::length).forEach(System.out::println);

        new Thread(() -> {
        }).start();

        doSomething(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Java");
            }
        });

        doSomething(()-> System.out.println(100));

    }
    public static void doSomething(Runnable runnableObj){
        runnableObj.run();
    }
}
