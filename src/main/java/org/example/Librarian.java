package org.example;

public class Librarian extends Person implements Employee{
    private char area;
    private long salary, phoneNumber;

    public Librarian(int employeeId, int age, String name, String address, long phoneNumber, long salary, char area) {
        super(employeeId, age, name, address);
        this.area = area;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public Librarian (int id, int age, String name, String address) {
        super(id, age, name, address);
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Librarian)) {
            return false;
        }
        Librarian other = (Librarian) obj;
        return other.getEmployeeId() == this.getEmployeeId();
    }

    @Override
    public String toString () {
        String librarian = "New librarian, called " + this.getName() + " works here.";
        return librarian;
    }

    public void work () {
        System.out.println("The employee " + this.getEmployeeId() + ", whose name is: " + this.getName() +
                "works as a librarian in this library.");
    }

    public char getArea() {
        return area;
    }

    public void setArea(char area) {
        this.area = area;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
