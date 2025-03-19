package org.example;

public class Person {
    private String name, address;
    private int age;

    public Person(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }
    public void work() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
