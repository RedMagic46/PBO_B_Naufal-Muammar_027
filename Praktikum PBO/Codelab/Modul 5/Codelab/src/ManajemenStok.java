import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        daftarBarang.add(new Barang("Garam", 10));
        daftarBarang.add(new Barang("Madu", 20));

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Stok awal: ");
                    try {
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        Barang barangBaru = new Barang(nama, stok);
                        daftarBarang.add(barangBaru);
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\nDaftar Barang:");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi stoknya.");
                        break;
                    }

                    System.out.println("\nPilih barang untuk dikurangi stok:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        System.out.println(i + ". " + daftarBarang.get(i).getNama() + " - Stok: " + daftarBarang.get(i).getStok());
                    }

                    try {
                        System.out.print("Masukkan indeks barang: ");
                        int indeks = scanner.nextInt();
                        System.out.print("Jumlah yang akan diambil: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        Barang barangDipilih = daftarBarang.get(indeks);

                        if (jumlah > barangDipilih.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barangDipilih.getNama() + " hanya tersisa " + barangDipilih.getStok());
                        }

                        barangDipilih.setStok(barangDipilih.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }

        scanner.close();
    }
}