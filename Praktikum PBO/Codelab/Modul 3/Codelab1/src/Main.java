// Kelas Main yaitu kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        /* Membuat objek KarakterGame dengan nama Karakter Umum dan kesehatan 100.
        Namun, objek ini tidak digunakan dimanapun */
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        // membuat objek Pahlawan yang bernama brimstone dengan kesehatan 150
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        // membuat objek Musuh yang bernama viper dengan kesehatan 200
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal karakter dalam permainan
        System.out.println("Status Awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

        brimstone.serang(viper); // brimstone menyerang viper menggunakan method yang ada dalam kelas Pahlawan yang di-Override dari superclass KarakterGame
        viper.serang(brimstone); // viper menyerang brimstone menggunakan method yang ada dalam kelas Musuh yang di-Override dari superclass KarakterGame
    }
}
