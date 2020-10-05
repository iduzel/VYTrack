package com.cybertek.tests.ws;

public class Person {

    public String name;
    public int yas;
    private String email;

    public void setEmail(String email) {

        if(email.contains("@")){
            this.email = email;
        }else{
            this.email = "Invalid Email";
        }

    }


    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Person: "+ name+ "\n"+ "yas: "+ yas + "\n"+"email: "+ email ;
    }
}
