import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Igra {
    private int izvucenBroj;
    private ArrayList<Integer> izvuceniBrojevi = new ArrayList<>();

    public ArrayList<Integer> getIzvuceniBrojevi() {
        while(izvuceniBrojevi.size() < 20){
            izvuceniBrojevi.add(izvuciBroj());
        }
        return izvuceniBrojevi;
    }

    public int izvuciBroj(){
        Random random = new Random();
        return 1 + random.nextInt(46);
    }

}

