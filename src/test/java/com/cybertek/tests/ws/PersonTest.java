package com.cybertek.tests.ws;

public class PersonTest {
    public static void main(String[] args) {

       Person person = new Person();

       person.name="Ali";
      person.yas=17;
      person.setEmail("duzel@gmail.com");
      person.getEmail();


        System.out.println(person.toString());

    }


}
