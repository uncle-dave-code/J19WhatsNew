package com.uncledavecode;

record Address(String street, String city) {
}

record Person(String name, int age, Address address) {
}