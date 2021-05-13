package com.geekbrains.lesson13_SpringCore.current.simple;

import org.springframework.stereotype.Component;

@Component
public class ProductService {
    public void getProducts() {
        System.out.println("Получен список товаров");
    }
}
