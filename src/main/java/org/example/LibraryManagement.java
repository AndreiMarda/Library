package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Long.parseLong;

public class LibraryManagement {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void startLibrary () throws IOException {
        try {
            int id, age;
            String name, address;
            long phoneNumber, salary;
            System.out.println("Welcome to the Library Management Application. \n\n" +
                    "1- Add Clerk\n" +
                    "2- Add Librarian\n" +
                    "3- View Issued Books History" +
                    "4- View All Books in Library" +
                    "5- Logout\n\n" +
                    "------------------------------------------\n\n" +
                    "Introduce your choice: ");


            String choice = bufferedReader.readLine();
            long intChoice = parseLong(choice);

            switch ((int)intChoice){
                case 1: // Clerk
                    id = intValue(bufferedReader, 0); // order == 0 for id
                    age = intValue(bufferedReader, 1); // order == 1 for age
                    name = stringValue(bufferedReader, 0); // order == 0 for name
                    address = stringValue(bufferedReader, 1); // order == 1 for address
                    phoneNumber = longValue(bufferedReader, 0); // order == 0 for phone
                    salary = longValue(bufferedReader, 1); // order == 1 for salary

                    Clerk clerk = new Clerk(id, name, age, address, phoneNumber, salary);
                    break;
                case 2: // Librarian
                    id = intValue(bufferedReader, 0); // order == 0 for id
                    age = intValue(bufferedReader, 1); // order == 1 for age
                    name = stringValue(bufferedReader, 0); // order == 0 for name
                    address = stringValue(bufferedReader, 1); // order == 1 for address
                    phoneNumber = longValue(bufferedReader, 0); // order == 0 for phone
                    salary = longValue(bufferedReader, 1); // order == 1 for salary

                    Librarian librarian = new Librarian();
                    break;
                case 3: // View Issued Books History

                    break;
                case 4: // View All Books in Library

                    break;
                case 5: // Close
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("closing...");
        }
    }

    public String stringValue (BufferedReader bufferedReader, int order) {
        if (order == 0) {
            System.out.print("Enter Name: ");
        }
        if (order == 1) {
            System.out.print("Enter Address: ");
        }
        String value = readElement(bufferedReader);
        return value;
    }
    public String createName (BufferedReader bufferedReader) {
        System.out.print("Enter Name: ");
        String name = readElement(bufferedReader);
        return name;
    }

    public String createAddress (BufferedReader bufferedReader) {
        System.out.print("Enter Address: ");
        String address = readElement(bufferedReader);
        return address;
    }

    public long longValue (BufferedReader bufferedReader, int order) {
        long value = 0L;
        if (order == 0) {
            System.out.print("Enter phone number: ");
        }
        if (order == 1) {
            System.out.print("Enter the salary: ");
        }
        StringBuilder temp = new StringBuilder(readElement(bufferedReader));
        boolean isNumberPhone = isNumber(temp);
        if (isNumberPhone) {
            value = parseLong(temp.toString());
        }
        return value;
    }

    public int intValue(BufferedReader bufferedReader, int order) { // order 0 for id, order 1 for age
        long value = 0L;
        if (order == 0) {
            System.out.print("Enter id: ");
        }
        if (order == 1) {
            System.out.print("Enter age: ");
        }
        StringBuilder temp = new StringBuilder(readElement(bufferedReader));
        boolean isNumberPhone = isNumber(temp);
        if (isNumberPhone) {
            value = parseLong(temp.toString());
        }
        return (int)value;
    }

    public String readElement(BufferedReader bufferedReader) {
        String element = "";
        try {
            element = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public boolean isNumber(StringBuilder number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
