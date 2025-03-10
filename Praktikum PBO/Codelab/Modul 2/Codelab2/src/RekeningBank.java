public class RekeningBank {
    String nomorRekening;
    String namaPemilik;
    double saldo;
    void tampilkanInfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo + "\n");
    }

    void setorUang(double jumlah){
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor " + jumlah + " Saldo Sekarang: " + saldo);
    }

    void tarikUang(double jumlah){
        if (jumlah > saldo){
            System.out.println(namaPemilik + " menarik " + jumlah + " (Gagal. Saldo tidak mencukupi) Saldo saat ini: " + saldo);
        } else {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik " + jumlah + " (Berhasil) saldo sekarang: " + saldo);
        }
    }
}
