import java.util.Scanner;

public class librarysistem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedin = false;

        while(!loggedin){
            System.out.println("=== Library System ===");
            System.out.println("1. Login as student");
            System.out.println("2. Login as Admin");
            System.out.println("3.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    loginStudent(scanner);
                    break;
                case 2:
                    loginAdmin(scanner);
                    break;
                case 3:
                    System.out.println("Exit");
                    loggedin = true;
                    break;
                default :
                    System.out.println("invalid option, please try again.");


            }
        }
        scanner.close();

    }
}