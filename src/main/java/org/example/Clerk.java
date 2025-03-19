package org.example;

public class Clerk extends Person implements Employee{
    private int id;
    private long phoneNumber, salary;

    public Clerk (int id, String name, int age, String address, long phoneNumber, long salary) {
        super(age, name, address);
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public Clerk(int age, String name, String address) {
        super(age, name, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (! (obj instanceof Clerk))) {
            return false;
        }
        Clerk other = (Clerk) obj;

        return this.id == other.id;
    }
    public int getId() {
        return id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public long getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void work () {
        System.out.println("The employee " + this.getId() + ", whose name is: " + this.getName() +
                "works as a clark in this library.");
    }
}
