package org.example;

import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class LibraryManagement {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    //    private String directoryPath = "C:\\Java_Library_Project";
    public void startLibrary() throws IOException {

        while (true) {

            try {
                int id, age;
                String name, address;
                long phoneNumber, salary;
                System.out.print("Welcome to the Library Management Application. \n\n" +
                        "1- Clerk Operations\n" +
                        "2- Librarian Operations\n" +
                        "3- Books Operations\n" +
                        "4- Logout\n\n" +

                        "------------------------------------------\n\n" +
                        "Introduce your choice: ");


                String choice = bufferedReader.readLine();
                int intChoice = (int) parseLong(choice);

                switch (intChoice) {
                    case 1:

                        System.out.print(
                                "\nChoose the Clerk Operation:\n" +
                                "1- Add Clerk\n" +
                                "2- Find Clerk by Id\n" +
                                "3- View All Clerks\n" +
                                "4- Exit\n" +
                                "Your choice: "
                                );

                        String strClerkChoice = bufferedReader.readLine();
                        int clerkChoice = (int) parseLong(strClerkChoice);
                        switch(clerkChoice) {

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
                            case 2: // Find Clerk by Id
                                System.out.print("\nChoose the id of the clerk that you are interested in: ");
                                String newChoice = bufferedReader.readLine();
                                int idClerk = (int) parseLong(newChoice);
                                Clerk newClerk = findClerkById(idClerk);
                                System.out.println(
                                        "Id: " + newClerk.getEmployeeId() +
                                                "\nName: " + newClerk.getName() +
                                                "\nAge: " + newClerk.getAge() +
                                                "\nAddress: " + newClerk.getAddress() +
                                                "\nPhone Number: " + newClerk.getPhoneNumber() +
                                                "\nSalary: " + newClerk.getSalary()
                                );

                                break;
                            case 3: // View All Clerks
                                List<Clerk> clerks = getAllClerks();

                                if(clerks.isEmpty()) {
                                    System.out.println("The list of Clerks is empty.");
                                } else {
                                    System.out.println("\nList of Clerks: ");
                                    for(Clerk clerk_ : clerks) {
                                        System.out.println(
                                                "Id: " + clerk_.getEmployeeId() +
                                                        ", Name: " + clerk_.getName() +
                                                        ", Age: " + clerk_.getAge() +
                                                        ", Address: " + clerk_.getAddress() +
                                                        ", Phone number: " + clerk_.getPhoneNumber() +
                                                        "$, Salary: " + clerk_.getSalary()
                                        );
                                    }
                                }
                                break;
                            case 4: // Exit
                                System.out.println("Exiting from Clerk menu.");
                                return;
                        }
                        break;

                    case 2:

                        System.out.print(
                                "\nChoose the Librarian Operation:\n" +
                                        "1- Add Librarian\n" +
                                        "2- Find Librarian by Id\n" +
                                        "3- View All Librarians\n" +
                                        "4- Exit\n" +
                                        "Your choice: "

                        );

                        String strLibrarianChoice = bufferedReader.readLine();
                        int librarianChoice = (int) parseLong(strLibrarianChoice);

                        switch(librarianChoice) {

                            case 1: // add Librarian
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
                            case 2: // Find Librarian by Id
                                System.out.print("\nChoose the id of the librarian that you are interested in: ");
                                String idLibrarianChoice = bufferedReader.readLine();
                                int idLibrarian = (int) parseLong(idLibrarianChoice);
                                Librarian newLibrarian = findLibrarianById(idLibrarian);
                                System.out.println(
                                        "Id: " + newLibrarian.getEmployeeId() +
                                                "\nName: " + newLibrarian.getName() +
                                                "\nAge: " + newLibrarian.getAge() +
                                                "\nAddress: " + newLibrarian.getAddress() +
                                                "\nPhone Number: " + newLibrarian.getPhoneNumber() +
                                                "\nSalary: " + newLibrarian.getSalary() +
                                                "\nArea: " + newLibrarian.getArea()
                                );

                                break;
                            case 3: // View All Librarians
                                List<Librarian> librarians = getAllLibrarians();

                                if(librarians.isEmpty()) {
                                    System.out.println("List of librarians is empty.");
                                } else {
                                    System.out.println("List of Librarians: ");
                                    for (Librarian librarian_ : librarians) {
                                        System.out.println(
                                                "Id: " + librarian_.getEmployeeId() +
                                                        ", Name: " + librarian_.getName() +
                                                        ", Age: " + librarian_.getAge() +
                                                        ", Address: " + librarian_.getAddress() +
                                                        ", Phone number: " + librarian_.getPhoneNumber() +
                                                        ", Salary: " + librarian_.getSalary() +
                                                        "$, Area: " + librarian_.getArea()
                                        );
                                    }
                                }

                                break;
                            case 4: // Exit
                                System.out.println("Exiting from Librarians menu.");
                                return;
                        }

                        break;
                    case 3:
                        System.out.print(
                                "\nChoose the Book Operation:\n" +
                                        "1- Add Book\n" +
                                        "2- Find Book by Id\n" +
                                        "3- View Last Issued Book\n" +
                                        "4- View All Books From Library\n" +
                                        "5- Exit\n" +
                                        "Your choice: "

                        );

                        String strBookChoice = bufferedReader.readLine();
                        int BookChoice = (int) parseLong(strBookChoice);

                        switch(BookChoice) {
                            case 1: // Add Book
                                // Add Book
                                id = intValue(bufferedReader, 0);
                                String title = stringValue(bufferedReader, 2);
                                String author = stringValue(bufferedReader, 3);
                                String genre = stringValue(bufferedReader, 4);
                                String language = stringValue(bufferedReader, 5);
                                int publicationYear = intValue(bufferedReader, 2);
                                int pageCount = intValue(bufferedReader, 3);
                                int weight = intValue(bufferedReader, 4);
                                int price = intValue(bufferedReader, 5);

                                Book book = new Book(id, title, author, genre, language,
                                        publicationYear, pageCount, weight, price);

                                if (insertBook(book)) {
                                    System.out.println("Book with name " + book.getTitle() + " created successfully.");
//                            writeInFile(directoryPath, book, "books.txt");
                                } else {
                                    System.out.println("Error at book insertion!");
                                }

                                break;
                            case 2: // Find Book by Id
                                System.out.print("\nChoose the id of the Book that you are interested in: ");
                                String idBookChoice = bufferedReader.readLine();
                                int idBook = (int) parseLong(idBookChoice);
                                Book newBook = findBookById(idBook);
                                System.out.println(
                                        "Id: " + newBook.getId() +
                                                "\nTitle: " + newBook.getTitle() +
                                                "\nAuthor: " + newBook.getAuthor() +
                                                "\nGenre: " + newBook.getGenre() +
                                                "\nLanguage: " + newBook.getLanguage() +
                                                "\nPublication Year: " + newBook.getPublicationYear() +
                                                "\nPage Count: " + newBook.getPageCount() +
                                                "\nWeight: " + newBook.getWeight() +
                                                "\nPrice: " + newBook.getPrice()
                                );
                                break;


                            case 3: // View Last Issued Book

                                break;

                            case 4: // View All Books From Library
                                List<Book> books = getAllBooks();

                                if (books.isEmpty()){
                                    System.out.println("No books found in the library.");
                                } else {
                                    System.out.println("\n---List of Books---");
                                    for (Book book_ : books) {
                                        System.out.println(
                                                "Id: " + book_.getId() +
                                                        ", Title: " + book_.getTitle() +
                                                        ", Author: " + book_.getAuthor() +
                                                        ", Genre: " + book_.getGenre() +
                                                        ", Language: " + book_.getLanguage() +
                                                        ", Year: " + book_.getPublicationYear() +
                                                        ", Pages: " + book_.getPageCount() +
                                                        ", weight: " + book_.getWeight() + "g" +
                                                        ", Price: $" + book_.getPrice()
                                        );
                                    }
                                }
                                break;
                            case 5: // Exit
                                System.out.println("Exiting from Books menu.");
                                return;
                        }

                       break;
                    case 4: // Exit
                        System.out.println("Closing...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("\n\n");
            }
        }
    }

    public String stringValue(BufferedReader bufferedReader, int order) {
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

    public String createName(BufferedReader bufferedReader) {
        System.out.print("Enter Name: ");
        String name = readElement(bufferedReader);
        return name;
    }

    public String createAddress(BufferedReader bufferedReader) {
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


    public long longValue(BufferedReader bufferedReader, int order) {
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
        return (int) value;
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
        String sql = "INSERT INTO Clerks (id, name, age, address, phone_number, salary) VALUES (?,?,?,?,?,?)";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clerk.getEmployeeId());
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

    public Clerk findClerkById(int id) {
        String sql = "SELECT * FROM Clerks WHERE id = ?";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Clerk(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getLong("phone_number"),
                        rs.getLong("salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Clerk> getAllClerks() {
        String sql = "SELECT * FROM Clerks";

        List<Clerk> clerks = new ArrayList<>();

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
                Clerk clerk = new Clerk(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getLong("phone_number"),
                        rs.getLong("salary")
                );
                clerks.add(clerk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clerks;
    }


    public boolean insertLibrarian(Librarian librarian) {
        String sql = "INSERT INTO Librarians (id, name, age, address, phone_number, salary, area) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, librarian.getEmployeeId());
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

    public Librarian findLibrarianById(int id) {
        String sql = "SELECT * FROM Librarians WHERE id = ?";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Librarian(
                        rs.getInt("id"),
                        rs.getInt("age"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getLong("phone_number"),
                        rs.getLong("salary"),
                        rs.getString("area").charAt(0)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Librarian> getAllLibrarians() {
        String sql = "SELECT * FROM Librarians";

        List<Librarian> librarians = new ArrayList<>();

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
                Librarian librarian = new Librarian(
                        rs.getInt("id"),
                        rs.getInt("age"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getLong("phone_number"),
                        rs.getLong("salary"),
                        rs.getString("area").charAt(0)
                );
                librarians.add(librarian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librarians;
    }


    public boolean insertBook(Book book) {
        String sql = "INSERT INTO Books (title, author, genre, language, publication_year, page_count, weight, price) VALUES (?,?,?,?,?,?,?,?)";

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

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Books";
        List<Book> books = new ArrayList<>();
        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getString("language"),
                        rs.getInt("publication_year"),
                        rs.getInt("page_count"),
                        rs.getInt("weight"),
                        rs.getInt("price")
                );
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book findBookById(int id) {
        String sql = "SELECT * FROM Books WHERE id = ?";

        try (Connection conn = ServerConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getString("language"),
                        rs.getInt("publication_year"),
                        rs.getInt("page_count"),
                        rs.getInt("weight"),
                        rs.getInt("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
