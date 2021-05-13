package com.geekbrains.lesson9.reflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class classPerson = Person.class;
        Method[] methods = classPerson.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Person person = new Person("Alex",28,0);
        System.out.println(methods[2].invoke(person));
        methods[1].setAccessible(true);
//        methods[1].invoke(person, person);

        Person person1 = (Person) classPerson
                .getConstructor(String.class,int.class,int.class)
                .newInstance("Vicka",30,15000);
        System.out.println(person1);
    }
}
