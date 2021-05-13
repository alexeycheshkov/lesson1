package com.geekbrains.lesson13_SpringCore.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    @Autowired
    Cart cart;


    public void createOrder(){
        System.out.println("Ваш заказ:");
        List<Product> products = cart.getProductsInCart();
        for (Product product : products) {
            System.out.println(product.getTitle());
        }
        System.out.println("На общую сумму: " + products.stream().mapToInt(Product::getCost).sum());
    }
}
