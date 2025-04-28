package app;
import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        NonFiksi bukuNonFiksi = new NonFiksi("Habibie & Ainun", "B.J. Habibie", "Biografi");
        Fiksi bukuFiksi = new Fiksi("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy");

        bukuFiksi.displayInfo();
        bukuNonFiksi.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Naufal Muammar", "B027");
        Anggota anggota2 = new Anggota("Santun", "I429");

        anggota1.displayInfo();
        anggota2.displayInfo();
        System.out.println();

        anggota1.pinjamBuku("Harry Potter and the Sorcerer's Stone");
        anggota2.pinjamBuku("Habibie & Ainun", 3);
        System.out.println();

        anggota1.kembalikanBuku("Harry Potter and the Sorcerer's Stone");
        anggota2.kembalikanBuku("Habibie & Ainun");
    }
}