package TUGAS1; //package adalah untuk mengelompokkan program program yang terkait 

import java.util.Scanner;//untuk media sebagai penginputan

public class LibrarySystem {//yang dapat di aksek 1file java
    static Scanner scanner = new Scanner(System.in);
    static Student[] students = {
        new Student("202210370311203"),//untuk meyimpan nim login dari user
        new Student("202310370311122"),
    };
    static Admin admin = new Admin("admin", "admin");

    public static void main(String[] args) {
        int choice;
        while (true) { //menggunakan switch case
            System.out.println("\n===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your NIM : ");
                String nim = scanner.next();
                boolean found = false;
                for (Student student : students) {
                    if (student.checkNim(nim)) {
                        System.out.println("Successful Login as Student");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("User Not Found");
                }
            } else if (choice == 2) {
                System.out.print("Enter your username (admin): ");
                String username = scanner.next();
                System.out.print("Enter your password (admin): ");
                String password = scanner.next();
                if (admin.checkAdmin(username, password)) {
                    System.out.println("Successful Login as Admin");
                } else {
                    System.out.println("Admin User Not Found!!");
                }
            } else if (choice == 3) {
                System.out.println("adios");
                break;
            } else {
                System.out.println("Invalid option, please choose again.");
            }
        }
    }
}

//ini adalah fungsi main yang akan di jalan saat pada class lain