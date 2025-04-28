import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Plant plant1 = new Plant("Kipli");
        Plant plant2 = new Plant("Ucup");
        Farmer farmer1 = new Farmer("Agus", plant2.name);
        Farmer farmer2 = new Farmer("Bambang", plant1.name);

        System.out.println("Hello World");
        System.out.println("Current date and time : " + new Date());

        farmer1.talk();
        farmer2.talk();
    }
}
