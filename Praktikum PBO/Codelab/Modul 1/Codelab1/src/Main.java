// import library untuk mendapatkan waktu saat ini
import java.time.LocalDateTime;
// import library scanner untuk membaca input dari user
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // deklarasi variabel untuk menyimpan data
        String Name; // variabel untuk menyimpan nama
        char jenisKelamin; // variabel untuk menyimpan jenis kelamin
        int tahunLahir; // variabel untuk menyimpan tahun lahir
        int tahunSekarang = LocalDateTime.now().getYear(); // variabel untuk mendapatkan tahun sekarang
        Scanner scanner = new Scanner(System.in); // membuat scanner untuk meminta input dari user

        // meminta user untuk memasukkan nama
        System.out.print("Masukkan Nama Anda : ");
        Name = scanner.nextLine();

        // meminta user untuk memasukkan jenis kelamin
        System.out.print("Masukkan Jenis Kelamin Anda(L/P) : ");
        jenisKelamin = scanner.next().charAt(0); // mengambil karakter pertama dari input pengguna

        // meminta user untuk memasukkan tahun lahir
        System.out.print("Masukkan Tahun Lahir Anda : ");
        tahunLahir = scanner.nextInt();

        // menghitung umur berdasarkan tahun saat ini dikurangi tahun lahir
        int umur = tahunSekarang - tahunLahir;

        // menentukan jenis kelamin berdasarkan input user
        String gender;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') {
            gender = "Laki-laki"; // jika yang dimasukkan adalah L atau l, maka output jenis kelamin adalah Laki-laki
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            gender = "Perempuan"; // jika input yang dimasukkan adalah P atau p, maka output jenis kelamin adalah Perempuan
        } else {
            gender = "Tidak Diketahui"; // jika input yang dimasukkan adalah selain dari L atau P, maka jenis kelamin tidak diketahiu
        }

        // menampilkan informasi sesuai dengan hasil dari informasi yang telah dimasukkan oleh user
        System.out.println("Data Diri:");
        System.out.println("Nama          : " + Name);
        System.out.println("Jenis Kelamin : " + gender);
        System.out.println("Umur          : " + umur);

        // menutup scanner
        scanner.close();
    }
}