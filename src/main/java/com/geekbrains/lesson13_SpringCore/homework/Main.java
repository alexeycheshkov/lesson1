package com.geekbrains.lesson13_SpringCore.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        cart.add(productService.findByTitle("product#2"));
        cart.add(productService.findByTitle("product#4"));
        cart.add(productService.findByTitle("product#6"));

        orderService.createOrder();

        context.close();
    }
}
