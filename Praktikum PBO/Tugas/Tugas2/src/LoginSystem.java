import java.util.Scanner;
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();
        int pilihan;

        System.out.println("Menu: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
        pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1){
            admin.login();
        } else if (pilihan == 2) {
            mahasiswa.login();
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
}
