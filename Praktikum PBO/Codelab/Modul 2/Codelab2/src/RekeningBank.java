public class RekeningBank {

    // Atribut untuk menyimpan informasi rekening
    String nomorRekening; // menyimpan nomor rekening
    String namaPemilik; // Menyimpan nama pemilik rekening
    double saldo; // menyimpan jumlah saldo dalam rekening

    // Method yang digunakan untuk menampilkan informasi pemilik rekening
    void tampilkanInfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo + "\n");
    }

    // Method yang digunakan untuk menyetor uang
    void setorUang(double jumlah){
        if (jumlah > 0){ // Mengecek apakah jumlah yang ingin disetor valid
            saldo += jumlah; // Jika jumlahnya valid maka saldo akan ditambah
            System.out.println(namaPemilik + " menyetor " + jumlah + " Saldo sekarang: " + saldo);
        } else { // Jika jumlahnya tidak valid atau kurang dari 1 maka setoran akan gagal
            System.out.println("Jumlah setoran tidak boleh 0 atau minus!");
        }
    }

    // Method yang digunakan untuk menarik uang
    void tarikUang(double jumlah){
        if (jumlah > saldo){ // Mengecek apakah jumlah yang ditarik melebihi saldo atau tidak
            // Jika jumlah yang ditarik melebihi saldo maka proses penarikan akan gagal
            System.out.println(namaPemilik + " menarik " + jumlah + " (Gagal. Saldo tidak mencukupi) Saldo saat ini: " + saldo);
        } else if (jumlah <= 0) { // Mengecek apakah jumlah yang ditarik valid atau tidak
            // Jika jumlah yang ditarik kurang dari 0 atau sama dengan 0 maka proses penarikan akan gagal
            System.out.println("Gagal. Jumlah uang yang ditarik tidak boleh 0 atau minus!");
        } else { // Jika yang ditarik lebih dari 0 dan saldonya mencukupi maka proses penarikan akan berhasil
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik " + jumlah + " (Berhasil) saldo sekarang: " + saldo);
        }
    }
}
