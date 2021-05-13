package com.geekbrains.lesson11_hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Order.Id.class)
                .buildSessionFactory();
        Session session = null;

        try {
        boolean endProgram = true;
        Scanner scanner = new Scanner(System.in);
        while (endProgram) {
            try {
                System.out.println("Введите команду для выполнения запроса (/help для просмотра списка команд или /q для выхода из программы):");
                String stringQuery = scanner.nextLine();
                String[] arrayQuery = stringQuery.split(" ");
                switch (arrayQuery[0]) {
                    case "/findProductsByBuyer":
                        findProductsByBuyer(session,factory,arrayQuery[1]);
                        break;
                    case "/findBuyersByProduct":
                        findBuyersByProduct(session,factory,arrayQuery[1]);
                        break;
                    case "/removeBuyer":
                        removeBuyer(session,factory,arrayQuery[1]);
                        break;
                    case "/removeProduct":
                        removeProduct(session,factory,arrayQuery[1]);
                        break;
                    case "/buy":
                        buyProduct(arrayQuery[1], arrayQuery[2], session, factory);
                        break;
                    case "/addBuyer":
                        addBuyer(session, factory, arrayQuery[1]);
                        break;
                    case "/addProduct":
                        addProduct(session, factory, arrayQuery[1], arrayQuery[2]);
                        break;
                    case "/showBuyers":
                        showBuyers(session, factory);
                        break;
                    case "/showProducts":
                        showProducts(session, factory);
                        break;
                    case "/q":
                        endProgram = false;
                        scanner.close();
                        break;
                    case "/help":
                        System.out.println("\tСписок доступных команд:");
                        System.out.println("/findProductsByBuyer имя_покупателя - для просмотра списка товаров, купленных покупателем.");
                        System.out.println("/findBuyersByProduct имя_товара - для просмотра списка покупателей, купивших товар.");
                        System.out.println("/addBuyer имя_покпателя - для добавления покупателя.");
                        System.out.println("/removeBuyer имя_покупателя - для удаления покупателя.");
                        System.out.println("/addProduct наименование_товара стоимость_товара - для добавления товара.");
                        System.out.println("/removeProduct название_товара - для удаления товара.");
                        System.out.println("/buy имя_покупателя название_товара - для покупки товара.");
                        System.out.println("/showBuyers - для просмотра полного списка покупателей.");
                        System.out.println("/showProducts - для просмотра полного списка товаров.");
                        System.out.println("/q - для выхода из программы.");
                        break;
                    default:
                        System.out.println("Введены неверные данные для запроса.");
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Введен неверный формат команды.");
            }
        }

        } finally {
            factory.close();
            if (session!=null){
            session.close();
            }
        }
    }
    public static void findProductsByBuyer(Session session, SessionFactory factory, String buyerName){
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = (Buyer) session.createQuery("FROM Buyer b WHERE b.name = :name")
                    .setParameter("name",buyerName)
                    .getSingleResult();
            List<Order> orderList = buyer.getOrders();
            System.out.println("Покупатель "+buyerName+" купил следующие продукты:");
            for (Order order : orderList) {
                System.out.println(order.getProduct().getName()+" за "+order.getProduct().getPrice()+" рублей.");
            }
        } catch (NoResultException ex){
            System.out.println("Такого покупателя не существует.");
        } finally {
            session.getTransaction().commit();
        }
    }
    public static void findBuyersByProduct(Session session, SessionFactory factory, String productName){
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Product product = (Product) session.createQuery("FROM Product p WHERE p.name = :name")
                    .setParameter("name",productName)
                    .getSingleResult();
            List<Order> orderList = product.getOrders();
            System.out.println("Товар "+productName+" приобрели следующие покупатели:");
            for (Order order : orderList) {
                System.out.println(order.getBuyer().getName());
            }
        } catch (NoResultException ex){
            System.out.println("Такого товара не существует.");
        } finally {
            session.getTransaction().commit();
        }
    }
    public static void addBuyer (Session session, SessionFactory factory, String buyerName){

        session = factory.getCurrentSession();
        session.beginTransaction();
        try {
            Buyer buyer = (Buyer) session.createQuery("FROM Buyer b WHERE b.name = :name")
                    .setParameter("name",buyerName)
                    .getSingleResult();
            System.out.println("Такой покупатель уже существует в базе.");
        } catch (NoResultException exception){
            Buyer buyer1 = new Buyer();
            buyer1.setName(buyerName);
            session.save(buyer1);
            System.out.println("Покупатель добавлен в базу.");
        } finally {
            session.getTransaction().commit();
        }
    }
    public static void removeBuyer(Session session, SessionFactory factory, String buyerName){
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = (Buyer) session.createQuery("FROM Buyer b WHERE b.name = :name")
                    .setParameter("name",buyerName)
                    .getSingleResult();
            session.delete(buyer);
            System.out.println("Покупатель удален.");
        } catch (NoResultException ex){
            System.out.println("Такого покупателя не существует.");
        } finally {
            session.getTransaction().commit();
        }
    }
    public static void addProduct (Session session, SessionFactory factory, String productName, String price){
            session = factory.getCurrentSession();
            session.beginTransaction();
        try {
            Product product = (Product) session.createQuery("FROM Product p WHERE p.name = :name")
                    .setParameter("name",productName)
                    .getSingleResult();
            System.out.println("Такой товар уже существует в базе.");
        } catch (NoResultException ex){
            Product product1 = new Product();
            product1.setName(productName);
            product1.setPrice(Integer.parseInt(price));
            session.save(product1);
            System.out.println("Товар добавлен в базу.");
        } finally {
            session.getTransaction().commit();
        }
    }
    public static void removeProduct (Session session, SessionFactory factory, String productName){
       try {
           session = factory.getCurrentSession();
           session.beginTransaction();

           Product product = (Product) session.createQuery("FROM Product p WHERE p.name = :name")
                   .setParameter("name",productName)
                   .getSingleResult();

           session.delete(product);
           System.out.println("Товар удален.");

       } catch (NoResultException ex){
           System.out.println("Такого товара не существует.");
       } finally {
           session.getTransaction().commit();
       }
    }
    public static void buyProduct (String buyerName, String productName, Session session, SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").getResultList();
        List<Buyer> buyers = session.createQuery("from Buyer").getResultList();
        for (Buyer buyerFromList : buyers) {
            if (buyerFromList.getName().equals(buyerName)){
                for (Product productFromList : products) {
                    if (productFromList.getName().equals(productName)){
                        Buyer buyer = (Buyer) session.createQuery("FROM Buyer b WHERE b.name = :name")
                                .setParameter("name", buyerName)
                                .getSingleResult();
                        Product product = (Product) session.createQuery("FROM Product p WHERE p.name = :name")
                                .setParameter("name",productName)
                                .getSingleResult();
                        Order.Id orderKey = new Order.Id();
                        orderKey.setBuyerId(buyer.getId());
                        orderKey.setProductId(product.getId());

                        Order order = new Order();
                        order.setId(orderKey);
                        order.setProductPrice(product.getPrice());

                        session.save(order);
                        session.getTransaction().commit();
                        System.out.println("Товар добавлен в заказ.");
                        return;
                    } else {
                        continue;
                    }

                }
            } else {
                continue;
            }
        }
        System.out.println("Такого покупателя или товара нет в базе.");
        session.getTransaction().commit();
    }
    public static void showBuyers (Session session, SessionFactory factory){
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("from Buyer").getResultList();
            System.out.println("В базе находятся следующие покупатели:");
            for (Buyer buyer : buyers) {
                System.out.println(buyer.getName());
            }
            session.getTransaction().commit();
    }
    public static void showProducts (Session session, SessionFactory factory){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").getResultList();
        System.out.println("В базе имеются следующие товары:");
        for (Product product : products) {
            System.out.println(product.getName()+" - "+product.getPrice()+" руб.");
        }
        session.getTransaction().commit();
    }
}
