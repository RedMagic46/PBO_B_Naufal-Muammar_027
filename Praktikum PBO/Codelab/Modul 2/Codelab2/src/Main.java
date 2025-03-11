public class Main {
    public static void main(String[] args) {
        // Membuat dua objek dari kelas RekeningBank
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        // Mengisi atribut rekening1 dengan data pemilik, nomor rekening, dan saldo awal
        rekening1.namaPemilik = "Naufal Muammar";
        rekening1.nomorRekening = "202410370110027";
        rekening1.saldo = 5000;

        // Mengisi atribut rekening2 dengan data pemilik, nomor rekening, dan saldo awal
        rekening2.namaPemilik = "Santun";
        rekening2.nomorRekening = "202410370110429";
        rekening2.saldo = 99999;

        rekening1.tampilkanInfo(); // Menampilkan informasi rekening pertama
        rekening2.tampilkanInfo(); // Menampilkan informasi rekening kedua
        rekening1.setorUang(10000); // Menyetor uang ke rekening pertama sebesar 10.000
        rekening2.setorUang(1); // Menyetor uang ke rekening pertama sebesar 1
        System.out.println("\n");
        rekening1.tarikUang(20000); // Menarik uang dari rekening pertama sebesar 20.000
        rekening2.tarikUang(50000); // Menarik uang dari rekening kedua sebesar 50.000
        System.out.println("\n");
        rekening1.tampilkanInfo(); // Menampilkan kembali informasi rekening setelah transaksi dilakukan
        rekening2.tampilkanInfo(); // Menampilkan kembali informasi rekening setelah transaksi dilakukan
    }
}
