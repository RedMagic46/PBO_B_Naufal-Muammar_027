package com.praktikum.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.praktikum.users.*;
import com.praktikum.data.Barang;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Barang> barangDilaporkan = new ArrayList<>();
    public static void barangDilaporkan(Barang barangHilang) {
        barangDilaporkan.add(barangHilang);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        userList.add(new Mahasiswa("Naufal Muammar", "202410370110027"));
        userList.add(new Admin("Admin027", "password027", "Naufal Muammar", "202410370110027", userList));

        int pilihan = 0;
        do {
            System.out.println();
            System.out.println("Menu: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            if (pilihan == 1) {

                boolean login = false;
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                for (User user : userList) {
                    if (user instanceof Admin && user.login(username, password)) {
                        login = true;
                        user.displayInfo();
                        user.displayAppMenu();
                        break;
                    }
                }
                if (!login){
                    System.out.println("Login gagal! Username atau password salah!");
                }

            } else if (pilihan == 2) {

                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                boolean login = false;
                for (User user : userList) {
                    if (user instanceof Mahasiswa && user.login(nama, nim)) {
                        login = true;
                        user.displayInfo();
                        user.displayAppMenu();
                        break;
                    }
                }
                if (!login){
                    System.out.println("Login gagal! Nama atau NIM salah!");
                }

            } else if (pilihan == 0) {
                System.out.println("Keluar dari program.");

            } else {
                System.out.println("Pilihan Tidak Valid!");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
