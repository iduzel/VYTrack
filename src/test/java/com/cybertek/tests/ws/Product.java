package com.cybertek.tests.ws;

public class Product {

    public String marka;
    public String model;
    public String color;
    private int price;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product(String marka, String model, String color) {
        this.marka = marka;
        this.model = model;
        this.color = color;

    }

    public void setPrice(int price) {
        if(price>0 && price<100000){
            this.price = price;
            System.out.println("You can choose only A Class");
        }else if(price>100000 && price<200000){
            this.price = price;
            System.out.println("You can choose A or B Classes");
        }else{
            this.price = price;
            System.out.println("You can choose all the classes");
        }

    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                '}';
    }
}
