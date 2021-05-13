package com.geekbrains.lesson12_hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.sql.Time;
import java.util.concurrent.CountDownLatch;

public class MainOptimistic {
    public static void main(String[] args) {
        CountDownLatch counter = new CountDownLatch(8);
        Thread[] threadArray = new Thread[8];
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory()) {

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 8; i++) {
                final int u = i + 1;
                threadArray[i] = new Thread(() -> {
                    System.out.println(u + "-й поток запущен.");
                    for (int j = 0; j < 20000; j++) {
                        boolean update = false;
                        while (!update) {
                            Session session = factory.getCurrentSession();
                            session.beginTransaction();
                            Integer randomId = (int) ((Math.random() * 40) + 1);
                            Item item = session.get(Item.class, randomId);
                            int tempValue = item.getValue();
                            item.setValue(++tempValue);
                            uncheckSleep(5);
                            try {
                                session.getTransaction().commit();
                                update = true;
                            } catch (OptimisticLockException e) {
                                session.getTransaction().rollback();
                            }

                            if (session != null) {
                                session.close();
                            }
                        }
                    }
                    counter.countDown();
                });
                threadArray[i].start();
            }
            try {
                counter.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            verifySum();
            System.out.println("Прошло: " + (System.currentTimeMillis() - startTime) / 1000 + " секунд.");
            System.out.println("END");
        }
    }

    public static void verifySum() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Object sum = session.createNativeQuery("SELECT SUM(value) FROM items;").getSingleResult();
            System.out.println("Проверочная сумма в столбце равна: " + sum);
        }
    }

    public static void insertData() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();
        for (int i = 0; i < 40; i++) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Item item = new Item();
            item.setValue(0);
            session.save(item);
            session.getTransaction().commit();
        }
    }
    public static void uncheckSleep (int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
