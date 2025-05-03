package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.AdminActions;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;
    Scanner scanner = new Scanner(System.in);

    public void manageItems(){
        System.out.println(">>Fitur Kelola Barang Belum Tersedia");
    }

    public void manageUsers(){
        System.out.println(">>Fitur Kelola Mahasiswa Belum Tersedia");
    }

    @Override
    public void displayAppMenu(){
        int pilihan;
        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Kelola Laporan barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan anda: ");
            pilihan = scanner.nextInt();
            if (pilihan == 1){
                manageItems();
            } else if (pilihan == 2) {
                manageUsers();
            } else if (pilihan == 0){
                System.out.println("Logging out...");
            } else {
                System.out.println("Pilihan Tidak Valid");
            }
        } while (pilihan != 0);
    }

    public Admin(String username, String password, String nama, String nim) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}
