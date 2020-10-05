package com.cybertek.tests.ws;

public class ProductManager {

    public void ekle(Product product){
        System.out.println("Database'e eklendi");
        product.setPrice(25000);
        System.out.println("product.getPrice() = " + product.getPrice());
        product.setId(product.marka.substring(0,2)+product.model.substring(0,2)+product.color.substring(0,2));
    }

}
