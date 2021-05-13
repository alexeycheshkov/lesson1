package com.geekbrains.lesson2_OOP;

public class MainApp {
    static class Human {
        private Transport currentTransport;

        public void stop(){
            if (currentTransport!=null){
                currentTransport.stop();
                currentTransport=null;
            } else {
                System.out.println("Человек никуда не ехал");
            }
        }
        public void start(Transport transport){
            transport.start();
            this.currentTransport=transport;
        }
    }
    static class Car implements Transport {

        @Override
        public void start() {
            System.out.println("Человек поехал на машине.");
        }

        @Override
        public void stop() {
            System.out.println("Человек остановил машину.");
        }
    }

    static class Skate implements Transport {

        @Override
        public void start() {
            System.out.println("Человек поехал на скейте.");
        }

        @Override
        public void stop() {
            System.out.println("Человек остановил скейт");
        }
    }

    public static void main(String[] args) {
        Flyable[] flyables = {
                (Flyable) new Duck(),
                (Flyable) new Airplane(),
        };
        for (Flyable flyable : flyables) {
            flyable.fly();
        }
        Human human = new Human();
        Car car = new Car();
        human.stop();
        human.start(car);
        human.stop();
    }
}
