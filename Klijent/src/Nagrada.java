import java.util.HashMap;

public class Nagrada {
    private static HashMap<Integer, Integer> nagrade = new HashMap<Integer, Integer>();

    public Nagrada(){
        nagrade.put(6,25);  // Broj pogodjenih 6, nagrada je novac puta 25
        nagrade.put(5,15);  // Broj pogodjenih 5, nagrada je novac puta 15
        nagrade.put(4,10);  // Broj pogodjenih 4, nagrada je novac puta 10
        nagrade.put(3,7);  // Broj pogodjenih 3, nagrada je novac puta 7
        nagrade.put(2,4);  // Broj pogodjenih 2, nagrada je novac puta 4
        nagrade.put(1,2);  // Broj pogodjenih 1, nagrada je novac puta 2
    }

    // Metoda za dodelu nagrade korisniku
    public void dodeliNagradu(Korisnik korisnik){
        int pogodjeni = korisnik.getBrojPogodjenihBrojeva();
        // Provera da li postoji nagrada za broj pogodjenih brojeva
        if(nagrade.containsKey(pogodjeni)){
            double nagrada = korisnik.getOpklada() * nagrade.get(korisnik.getBrojPogodjenihBrojeva());
            System.out.println("Dobitak je x" + nagrade.get(korisnik.getBrojPogodjenihBrojeva()));
            korisnik.setNagrada(nagrada);
            System.out.println("Osvojili ste: " + korisnik.getNagrada() + " rsd.");
        }
    }
}
