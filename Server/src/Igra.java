import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Igra {
    private int izvucenBroj;
    private ArrayList<Integer> izvuceniBrojevi = new ArrayList<>();

    // Metoda koja vraca listu izvucenih brojeva
    public ArrayList<Integer> getIzvuceniBrojevi() {
        while(izvuceniBrojevi.size() < 20){
            izvuceniBrojevi.add(izvuciBroj());
        }
        return izvuceniBrojevi;
    }

    // Metoda za izvlacenje slucajnog broja izmedju 1 i 46 (ukljucujući oba kraja)
    public int izvuciBroj(){
        Random random = new Random();
        return 1 + random.nextInt(46);
    }
}
