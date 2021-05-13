package com.geekbrains.lesson13_SpringCore.homework;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private List<Product> productsInCart;

    @PostConstruct
    public void init(){
        productsInCart = new ArrayList<>();
    }

    public void add(Product product){
        productsInCart.add(product);
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }
}
