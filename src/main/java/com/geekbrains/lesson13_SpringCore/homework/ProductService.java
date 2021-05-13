package com.geekbrains.lesson13_SpringCore.homework;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(new Product(i+1,"product#"+(i+1),i+i/2+i*2));
        }
    }

    public void printAll(){
        for (Product product : productList) {
            System.out.println(product.getTitle()+" - "+product.getCost());
        }
    }
    public Product findByTitle(String title){
        Product returnProduct=null;
        for (Product product : productList) {
            if (product.getTitle().equals(title)){
                returnProduct = product;
                break;
            }
        }
        return returnProduct;
    }
}
