package com.uncledavecode;

public class JEP405RecordPattern {

    //JEP 405 - Records Pattern (Preview)
    //https://openjdk.java.net/jeps/405

    public void printRecord(Object object){
        //Origin Way
        if(object instanceof Person){
            Person person = (Person) object;
            System.out.println("Origin way: " + person.name() + " " + person.age() + " " + person.address().street()+ " " + person.address().city());
        }

        //Old JDK 18 Way
        if(object instanceof Person person){
            System.out.println("Old way: " + person.name() + " " + person.age() + " " + person.address().street()+ " " + person.address().city());
        }

        //New JDK 19 Way
        if(object instanceof Person(String name, int age, Address address)){
            System.out.println("New way: " + name + " " + age + " " + address.street()+ " " + address.city());
        }

        //New nestled JDK 19 Way
        if(object instanceof Person(String name, int age, Address(String street, String city))){
            System.out.println("Nestled way: " + name + " " + age + " " + street + " " + city);
        }

    }
}
