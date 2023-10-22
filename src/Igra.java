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

    static class Nagrada extends Igra
    {
        private static HashMap<Integer, Integer> nagrade = new HashMap<Integer, Integer>();

        public Nagrada(){
            nagrade.put(6,25);  // Broj pogodjenih 6, nagrada je novac puta 25
            nagrade.put(5,15);  // Broj pogodjenih 5, nagrada je novac puta 15
            nagrade.put(4,10);  // Broj pogodjenih 4, nagrada je novac puta 10
            nagrade.put(3,7);  // Broj pogodjenih 3, nagrada je novac puta 7
            nagrade.put(2,4);  // Broj pogodjenih 2, nagrada je novac puta 4
            nagrade.put(1,2);  // Broj pogodjenih 1, nagrada je novac puta 2
        }

        public void dodeliNagradu(Korisnik korisnik){
            int pogodjeni = korisnik.getBrojPogodjenihBrojeva();
            if(nagrade.containsKey(pogodjeni)){
                double nagrada = korisnik.getOpklada() * nagrade.get(korisnik.getBrojPogodjenihBrojeva());
                 System.out.println("Dobitak je x" + nagrade.get(korisnik.getBrojPogodjenihBrojeva()));
                korisnik.setNagrada(nagrada);
                System.out.println("Osvojili ste: " + korisnik.getNagrada() + " rsd.");
            }
        }
        }
    }

