import java.util.Scanner;
public class Admin {
    String username;
    String password;
    String usnValid = "Admin027";
    String passValid = "password027";
    Scanner scanner = new Scanner(System.in);

    void login(){
        System.out.print("Masukkan username: ");
        username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        password = scanner.nextLine();
        if (username.equals(usnValid) && password.equals(passValid)){
            System.out.println("Login Berhasil!");
        } else {
            System.out.println("Login gagal! Username atau Password salah");
        }
    }
}
