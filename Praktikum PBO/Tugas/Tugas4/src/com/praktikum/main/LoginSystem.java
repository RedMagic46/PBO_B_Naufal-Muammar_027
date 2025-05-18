package com.praktikum.main;
import java.util.Scanner;
import com.praktikum.users.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println();
            System.out.println("Menu: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                Admin admin = new Admin("Admin027", "password027", "Naufal Muammar", "202410370110027");
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    admin.displayInfo();
                    admin.displayAppMenu();
                } else {
                    System.out.println("Login gagal! Username atau password salah!");
                }

            } else if (pilihan == 2) {
                Mahasiswa mhs = new Mahasiswa("Naufal Muammar", "202410370110027");
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                if (mhs.login(nama, nim)) {
                    mhs.displayInfo();
                    mhs.displayAppMenu();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah!");
                }

            } else if (pilihan == 0){
                System.out.println("Keluar dari program.");

            } else {
                System.out.println("Pilihan Tidak Valid!");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
