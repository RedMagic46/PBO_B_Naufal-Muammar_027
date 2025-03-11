public class Main {
    public static void main(String[] args) {

        // Membuat dua objek dari kelas Hewan
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        // Mengisi atribut hewan1 dengan nama, jenis dan suara
        hewan1.nama = "Kucing";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Nyann~~";

        // Mengisi atribut hewan2 dengan nama, jenis dan suara
        hewan2.nama = "Anjing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Woof-woof!";

        hewan1.tampilkanInfo(); // Menampilkan informasi dari hewan1 sesuai dengan atribut yang dimasukkan
        hewan2.tampilkanInfo(); // Menampilkan informasi dari hewan1 sesuai dengan atribut yang dimasukkan
    }
}
