class KarakterGame { // Kelas KarakterGame sebagai superclass dari kelas Pahlawan dan Musuh
    // atribut private yang digunakan untuk menyimpan nama dan kesehatan karakter
    private String nama;
    private int kesehatan;

    // Konstruktor untuk menginisialisasi objek KarakterGame dengan nama dan kesehatan yang telah ditentukan
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() { //Getter untuk mengambil nilai atribut nama
        return nama;
    }

    public int getKesehatan() { // Getter untuk mengambil nilai atribut kesehatan
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) { // Setter untuk mengubah nilai atribut kesehatan
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) { // method serang yang akan dioverride oleh subclass Pahlawan dan Musuh
        System.out.println("method yang akan dioverride oleh subclass");
    }
}
