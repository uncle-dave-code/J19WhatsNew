package com.uncledavecode;

public class JEP427PatternMatchingSwitch {
    // JEP 427: Pattern Matching for switch (Preview)
    // https://openjdk.java.net/jeps/427

    public void printSwitchPatterns(Object object){

        //Old way JDK 18
        switch (object){
            case Person person ->
                    System.out.println("Old way: " + person.name() + " Age: " + person.age() + " Address:" + person.address().street() + ", " + person.address().city());

            default -> throw new IllegalStateException("Unexpected value: " + object);
        }

        // New JDK 19 way
        switch (object){
            case Person(String name,int age,Address address) ->
                    System.out.println("New way: " + name + " Age: " + age + " Address:" + address.street() + ", " + address.city());

            default -> throw new IllegalStateException("Unexpected value: " + object);
        }

        // New JDK 19 nestled way
        switch (object){
            case Person(String name,int age,Address(String street,String city)) ->
                    System.out.println("Nestled way: " + name + " Age: " + age + " Address:" + street + ", " + city);

            default -> throw new IllegalStateException("Unexpected value: " + object);
        }
    }

    public void printSwitchGuards(Object object){
        //Old way JDK 18
//        switch (object){
//            case Person person && person.age() > 18 ->
//                    System.out.println("Old way greater than 18: " + person.name() + " Age: " + person.age() + " Address:" + person.address().street() + ", " + person.address().city());
//            case Person person && person.age() <= 18 ->
//                    System.out.println("Old way less than or equal to 18: " + person.name() + " Age: " + person.age() + " Address:" + person.address().street() + ", " + person.address().city());
//            default -> throw new IllegalStateException("Unexpected value: " + object);
//        }

        //New way JDK 19
        switch (object){
            case Person(String name,int age,Address(String street,String city)) person when age > 18 ->
                    System.out.println("New way greater than 18: " + name + " Age: " + age + " Address:" + street + ", " + city);
            case Person(String name,int age,Address(String street,String city)) person when age <= 18 ->
                    System.out.println("New way less than or equal to 18: " + name + " Age: " + age + " Address:" + street + ", " + city);
            default -> throw new IllegalStateException("Unexpected value: " + object);
        }
    }
}
