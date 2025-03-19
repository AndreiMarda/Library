package org.example;

public class Clerk extends Person implements Employee{
    private long phoneNumber, salary;

    public Clerk (int id, String name, int age, String address, long phoneNumber, long salary) {
        super(id, age, name, address);
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public Clerk(int id, int age, String name, String address) {
        super(id, age, name, address);
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

        return this.getId() == other.getId();
    }
    @Override
    public String toString () {
        String clerk = new String("New clerk, called " + this.getName() + " works here.");
        return clerk;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public long getSalary() {
        return salary;
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
