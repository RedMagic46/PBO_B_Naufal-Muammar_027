import java.util.Scanner;
public class Mahasiswa {
    String namaValid = "Naufal Muammar";
    String nimValid = "202410370110027";
    String nama;
    String nim;
    Scanner scanner = new Scanner(System.in);

    void login(){
        System.out.print("Masukkan nama: ");
        nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        nim = scanner.nextLine();
        if (nama.equalsIgnoreCase(namaValid) && nim.equals(nimValid)){
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah!");
        }
    }

    void displayInfo(){
        System.out.println("Login berhasil!");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}
