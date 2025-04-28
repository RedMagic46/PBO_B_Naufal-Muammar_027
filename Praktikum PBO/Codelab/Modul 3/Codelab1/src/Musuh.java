class Musuh extends KarakterGame { // Kelas Musuh yang merupakan turunan dari KarakterGame
    public Musuh(String nama, int kesehatan) { //Konstruktor untuk inisialisasi objek Musuh dengan nama dan kesehatan
        super(nama, kesehatan);// memanggil konstruktor dari superclass (KarakterGame)
    }

    @Override // meng-Override method serang dari superclass
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!"); // Menampilkan pesan serangan
        target.setKesehatan(target.getKesehatan() - 15); // Mengurangi kesehatan target sebesar 15 poin akibat serangan
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan()); // Menampilkan kesehatan target setelah diserang
    }
}