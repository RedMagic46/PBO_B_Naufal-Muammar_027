public class Main {
    public static void main(String[] args) {
        String[] namaHari = new String[3];
        namaHari[0] = "Senin";
        namaHari[1] = "Selasa";
        namaHari[2] = "Rabu";

        int[] angkaKeberuntungan = {3, 5, 7, 9};
        System.out.println("Hari Pertama: "+ namaHari[0]);
        System.out.println("Hari Terakhir: "+ namaHari[namaHari.length-1]);
        System.out.println("Panjang Array Angka Keberuntungan: "+ angkaKeberuntungan.length);

        System.out.println("\nNama Nama Hari:");
        for (int i=0; i < namaHari.length; i++){
            System.out.println("Index ke-" + i + ": " + namaHari[i]);
        }
        System.out.println("\nAngka Keberuntungan(for-each):");
        for (int angka : angkaKeberuntungan){
            System.out.println(angka);
        }

    }
}
