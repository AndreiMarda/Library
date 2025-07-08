package org.example;

public class Person implements Employee{
    private String name, address;
    private int age, employeeId;

    public Person(int employeeId, int age, String name, String address) {
        this.employeeId = employeeId;
        this.age = age;
        this.name = name;
        this.address = address;
    }
    public void work() {
        System.out.println("This is a normal employee, having the id number " + this.employeeId);
    }

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
