public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.namaPemilik = "Naufal Muammar";
        rekening1.nomorRekening = "202410370110027";
        rekening1.saldo = 5000;
        rekening2.namaPemilik = "Santun";
        rekening2.nomorRekening = "202410370110429";
        rekening2.saldo = 99999;

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
        rekening1.setorUang(10000);
        rekening2.setorUang(1);
        System.out.println("\n");
        rekening1.tarikUang(20000);
        rekening2.tarikUang(50000);
        System.out.println("\n");
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
