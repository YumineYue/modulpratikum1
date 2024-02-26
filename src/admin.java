import java.util.Scanner;

public class admin {
      private static void loginStudent(Scanner scanner){
        System.out.println("Enter your NIM :");
        String nimInput = scanner.nextLine();
        long nim = 0;
        try {
            nim = Long.parseLong(nimInput);
        } catch (NumberFormatException e) {
            System.out.println("invalid NIM, please try again.");
            return;
        }
        if(nim >= 1000000000000000L && nim <= 9999999999999999L) {
            System.out.println("Succesful login as student");
        } else {
            System.out.println("invalid NIM, please try again.");
        }
    }

    //buat class admin pisahin admin dari class main
    private static void loginAdmin(Scanner scanner){
        System.out.println("Enter your username(Admin) : ");
        String username = scanner.nextLine();
        System.out.println("Enter your password(Admin) : ");
        String password = scanner.nextLine();


        if (username.equals("admin" ) && password.equals("password")) {
            System.out.println("Welcome, admin!");
        }else{
            System.out.println("invalid credentials, please try again");
        }

    }

}


