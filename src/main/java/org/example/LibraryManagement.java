package org.example;

import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Long.parseLong;

public class LibraryManagement {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    private String directoryPath = "C:\\Java_Library_Project";
    public void startLibrary () throws IOException {

        while (true) {

            try {
                int id, age;
                String name, address;
                long phoneNumber, salary;
                System.out.print("Welcome to the Library Management Application. \n\n" +
                        "1- Add Clerk\n" +
                        "2- Add Librarian\n" +
                        "3- Add Book\n" +
                        "4- View Issued Books History\n" +
                        "5- View All Books in Library\n" +
                        "6- View All clerks\n" +
                        "7- View All librarians\n" +
                        "8- Logout\n\n" +
                        "------------------------------------------\n\n" +
                        "Introduce your choice: ");


                String choice = bufferedReader.readLine();
                long intChoice = parseLong(choice);

                switch ((int)intChoice){
                    case 1: // add Clerk
                        id = intValue(bufferedReader, 0); // order == 0 for id
                        age = intValue(bufferedReader, 1); // order == 1 for age
                        name = stringValue(bufferedReader, 0); // order == 0 for name
                        address = stringValue(bufferedReader, 1); // order == 1 for address
                        phoneNumber = longValue(bufferedReader, 0); // order == 0 for phone
                        salary = longValue(bufferedReader, 1); // order == 1 for salary

                        Clerk clerk = new Clerk(id, name, age, address, phoneNumber, salary);

                        if (insertClerk(clerk)) {
                            System.out.println("Clerk with name " + clerk.getName() + " created successfully.");
//                            writeInFile(directoryPath, clerk, "clerks.txt");
                        } else {
                            System.out.println("Error at clerk insertion!");
                        }


                        break;
                    case 2: // add Librarian
                        id = intValue(bufferedReader, 0); // order == 0 for id
                        age = intValue(bufferedReader, 1); // order == 1 for age
                        name = stringValue(bufferedReader, 0); // order == 0 for name
                        address = stringValue(bufferedReader, 1); // order == 1 for address
                        phoneNumber = longValue(bufferedReader, 0); // order == 0 for phone
                        salary = longValue(bufferedReader, 1); // order == 1 for salary
                        char area = readElement(bufferedReader).charAt(0);

                        Librarian librarian = new Librarian(id, age, name, address, phoneNumber, salary, area);

                        if (insertLibrarian(librarian)) {
                            System.out.println("Librarian with name " + librarian.getName() + " created successfully.");
//                            writeInFile(directoryPath, librarian, "librarians.txt");
                        } else {
                            System.out.println("Error at librarian insertion!");
                        }


                        break;
                    case 3: // Add Book
                        String title = stringValue(bufferedReader, 2);
                        String author = stringValue(bufferedReader, 3);
                        String genre = stringValue(bufferedReader, 4);
                        String language = stringValue(bufferedReader, 5);
                        int publicationYear = intValue(bufferedReader, 2);
                        int pageCount = intValue(bufferedReader, 3);
                        int weight = intValue(bufferedReader, 4);
                        int price = intValue(bufferedReader, 5);

                        Book book = new Book(title,author, genre, language,
                                publicationYear, pageCount, weight, price);

                        if (insertBook(book)) {
                            System.out.println("Book with name " + book.getTitle() + " created successfully.");
//                            writeInFile(directoryPath, book, "books.txt");
                        } else {
                            System.out.println("Error at book insertion!");
                        }

                        break;
                    case 4: // View Issued Books History

                        break;
                    case 5: // View All Books in Library

                        break;
                    case 6: // View all Clerks

                        break;
                    case 7: // View all Librarians

                        break;
                    case 8: // Close
                        return;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("closing...");
            }
        }
    }

    public String stringValue (BufferedReader bufferedReader, int order) {
        if (order == 0) {
            System.out.print("Enter Name: ");
        }
        if (order == 1) {
            System.out.print("Enter Address: ");
        }
        if (order == 2) {
            System.out.print("Enter Book Title: ");
        }
        if (order == 3) {
            System.out.print("Enter Book Author: ");
        }
        if (order == 4) {
            System.out.print("Enter Book genre: ");
        }
        if (order == 5) {
            System.out.print("Enter Book language: ");
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

//    public void writeInFile(String directoryPath, Object obj, String fileName) {
//
//        if (!(obj instanceof Clerk || obj instanceof Librarian || obj instanceof Book)) {
//            System.out.println("Invalid object type. Only Clerk, Librarian, or Book are allowed.");
//            return;
//        }
//
//        String filePath = directoryPath + File.separator + fileName;
//        Path path = Paths.get(filePath);
//
//        try {
//
//            Files.createDirectories(Paths.get(directoryPath));
//
//            if (!Files.exists(path)) {
//                Files.createFile(path);
//                System.out.println("File created: " + filePath);
//            }
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
//                writer.write(obj.toString());
//                writer.newLine(); // Add a new line for better formatting
//                System.out.println("Written to file: " + filePath);
//
//            } catch (IOException e) {
//                System.out.println("Error writing to file: " + e.getMessage());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public long longValue (BufferedReader bufferedReader, int order) {
        long value = 0L;
        if (order == 0) {
            System.out.print("Enter phone number: ");
        }
        if (order == 1) {
            System.out.print("Enter the salary: ");
        }
        StringBuilder temp = new StringBuilder(readElement(bufferedReader));
        boolean boolIsNumber = isNumber(temp);
        if (boolIsNumber) {
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
        if (order == 2) {
            System.out.print("Enter publication year: ");
        }
        if (order == 3) {
            System.out.print("Enter pageCount: ");
        }
        if (order == 4) {
            System.out.print("Enter weight: ");
        }
        if (order == 5) {
            System.out.print("Enter price: ");
        }
        StringBuilder temp = new StringBuilder(readElement(bufferedReader));
        boolean boolIsNumber = isNumber(temp);
        if (boolIsNumber) {
            value = parseLong(temp.toString());
        }
        return (int)value;
    }

    public char charValue(BufferedReader bufferedReader) {
        String ch = "";
        System.out.print("Enter area (char): ");
        try {
            ch = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        char c = ch.charAt(0);
        return c;
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

    public boolean insertClerk(Clerk clerk) {
        String sql = "INSERT INTO Clerks (id, name, age, address, phoneNumber, salary) VALUES (?,?,?,?,?,?)";

        try (Connection conn = ServerConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clerk.getId());
            pstmt.setString(2, clerk.getName());
            pstmt.setInt(3, clerk.getAge());
            pstmt.setString(4, clerk.getAddress());
            pstmt.setLong(5, clerk.getPhoneNumber());
            pstmt.setLong(6, clerk.getSalary());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Clerk inserted successfully to the database!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertLibrarian(Librarian librarian) {
        String sql = "INSERT INTO Librarians (id, name, age, address, phoneNumber, salary, area) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, librarian.getId());
            pstmt.setString(2, librarian.getName());
            pstmt.setInt(3, librarian.getAge());
            pstmt.setString(4, librarian.getAddress());
            pstmt.setLong(5, librarian.getPhoneNumber());
            pstmt.setLong(6, librarian.getSalary());
            pstmt.setString(7, String.valueOf(librarian.getArea()));

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Librarian inserted successfully to the database!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertBook(Book book) {
        String sql = "INSERT INTO Librarians (title, author, genre, language, publication_year, page_count, weight, price) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getGenre());
            pstmt.setString(4, book.getLanguage());
            pstmt.setInt(5, book.getPublicationYear());
            pstmt.setInt(6, book.getPageCount());
            pstmt.setInt(7, book.getWeight());
            pstmt.setInt(8, book.getPrice());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Book inserted successfully to the database!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
