package com.cybertek.tests.ws;

public class ProductTest {

    public static void main(String[] args) {
        Product product = new Product("BMW", "5.25","Black");

        ProductManager productManager = new ProductManager();
        productManager.ekle(product);

        System.out.println("--------------");


        System.out.println(product.toString());
    }
}
