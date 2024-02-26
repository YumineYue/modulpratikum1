package TUGAS1;

public class Admin {
    String username, password;

    public Admin(String username, String password) {
        this.username = username; //this untuk keyword yang digunakan untuk membuat object dari file dan method lain atau varibel
        this.password = password;
    }

    public boolean checkAdmin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }//boolean adalah tipe data yang mengembalikan nilai true dan false 
}

