class Pahlawan extends KarakterGame { // Kelas Pahlawan yang merupakan turunan dari KarakterGame
    public Pahlawan(String nama, int kesehatan) { //Konstruktor untuk inisialisasi objek Pahlawan dengan nama dan kesehatan
        super(nama, kesehatan); // memanggil konstruktor dari superclass (KarakterGame)
    }

    @Override // meng-Override method serang dari superclass
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!"); // Menampilkan pesan serangan
        target.setKesehatan(target.getKesehatan() - 20); // Mengurangi kesehatan target sebesar 20 poin akibat serangan
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan()); // Menampilkan kesehatan target setelah diserang
    }
}