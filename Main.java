package modul121;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BookList bookList = new BookList();
    static User[] userStudents = {
        new Student("John Doe", "202210370311203", "Engineering", "Computer Science"),
        new Student("Jane Smith", "202310370311122", "Business", "Finance")
    };
    static Admin admin = new Admin("admin", "admin");

    public static void main(String[] args) {
        bookList.addBook(new Book(1, "Java Programming", "John Doe", 10));
        bookList.addBook(new Book(2, "Introduction to Algorithms", "Thomas Cormen", 5));

        while (true) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputNim();
                    break;
                case 2:
                    admin.login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please choose again.");
            }
        }
    }

    static void inputNim() {
        System.out.print("Enter your NIM: ");
        String nim = scanner.next();
        boolean found = false;
        for (User user : userStudents) {
            if (user instanceof Student && ((Student) user).checkNim(nim)) {
                ((Student) user).menuStudent();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User Not Found");
        }
    }
}

class Book {
    private int id;
    private String title;
    private String author;
    private int stock;

    public Book(int id, String title, String author, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }
}

class BookList {
    private Book[] books;
    private int size;

    public BookList() {
        books = new Book[100]; // Assuming maximum capacity of 100 books
        size = 0;
    }

    public void addBook(Book book) {
        books[size++] = book;
    }

    public void displayBooks() {
        System.out.println("List of Books:");
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + books[i].getId() + ", Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor() + ", Stock: " + books[i].getStock());
        }
    }

    // Other methods like removing a book, searching a book by ID, etc.
}

abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void login();

    public void logout() {
        System.out.println("Logging out...");
    }
}

class Student extends User {
    protected String nim;
    protected String faculty;
    protected String program;

    public Student(String name, String nim, String faculty, String program) {
        super(name);
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }

    public boolean checkNim(String nim) {
        return this.nim.equals(nim);
    }

    public void menuStudent() {
        while (true) {
            System.out.println("\n===== Student Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Logout");
            System.out.print("Choose option (1-2): ");
            int choice = Main.scanner.nextInt();

            switch (choice) {
                case 1:
                    Main.bookList.displayBooks();
                    break;
                case 2:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option, please choose again.");
            }
        }
    }

    // Implementasi metode login() yang diperlukan
    public void login() {
        // Implementasi login untuk student
    }

    public void logout() {
        System.out.println("Logging out...");
    }
}

class Admin extends User {
    private String username;
    private String password;

    public Admin(String username, String password) {
        super("Admin");
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.out.print("Enter your username: ");
        String inputUsername = Main.scanner.next();
        System.out.print("Enter your password: ");
        String inputPassword = Main.scanner.next();
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            menuAdmin();
        } else {
            System.out.println("Admin User Not Found!!");
        }
    }

    public void menuAdmin() {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add a Student");
            System.out.println("2. Display Students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int choice = Main.scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option, please choose again.");
            }
        }
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = Main.scanner.next();
        System.out.print("Enter student nim: ");
        String nim = Main.scanner.next();
        if (nim.length() != 15) {
            System.out.println("Invalid nim length. NIM must be 15 characters.");
            return;
        }
        System.out.print("Enter student faculty: ");
        String faculty = Main.scanner.next();
        System.out.print("Enter student program: ");
        String program = Main.scanner.next();
        // Hapus deklarasi variabel student yang tidak digunakan
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        System.out.println("\nList of Students:");
        for (User user : Main.userStudents) {
            if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println("Name: " + student.name + ", NIM: " + student.nim + ", Faculty: " + student.faculty + ", Program: " + student.program);
            }
        }
    }

    public void logout() {
        System.out.println("Logging out...");
    }
}
