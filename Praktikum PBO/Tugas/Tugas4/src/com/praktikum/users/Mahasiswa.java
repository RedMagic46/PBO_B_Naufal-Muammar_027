package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }
    Scanner scanner = new Scanner(System.in);

    public void reportItem(){
        System.out.print("Nama barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Deskripsi barang: ");
        String deskripsiBarang = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasiBarang = scanner.nextLine();
        System.out.println("Informasi barang telah tersimpan.");
    }

    public void viewReportedItems(){
        System.out.println(">>Fitur Lihat Laporan Belum Tersedia");
    }

    @Override
    public void displayAppMenu(){
        int pilihan;
        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Masukkan Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            if (pilihan == 1){
                reportItem();
            } else if (pilihan == 2) {
                viewReportedItems();
            } else if (pilihan == 0){
                System.out.println("Logging out...");
            } else {
                System.out.println("Pilihan Tidak Valid!");
            }
        } while (pilihan != 0);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}
