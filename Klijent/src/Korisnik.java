import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Korisnik {
    private ArrayList<Integer> mojiBrojevi = new ArrayList<Integer>(); // Lista brojeva koje je korisnik odabrao
    private static ArrayList<Integer> pogodjeniBrojevi = new ArrayList<>(); // Lista brojeva koje je korisnik pogodio

    private int idKorisnika; // Identifikator korisnika
    private static Korisnik trenutniKorisnik;
    private int opklada; // Iznos opklade korisnika
    private int brojPogodjenihBrojeva = 0; // Broj brojeva koje je korisnik pogodio
    private double nagrada = 0; // Iznos nagrade koji je korisnik osvojio

    public Korisnik(int idKorisnika){
        this.idKorisnika = idKorisnika;
        trenutniKorisnik = this;
    }

    // Getteri i setteri za različite atribute korisnika

    // Metoda za dodavanje brojeva koje je korisnik odabrao
    public void dodajBroj(int broj) {
        mojiBrojevi.add(broj);
    }

    // Metoda za dodavanje brojeva koje je korisnik pogodio na listu dobitnih brojeva
    public static void dodajDobitneBrojeve(ArrayList<Integer> listaDobitnihBrojeva, Korisnik korisnik){
        for(Integer izvucenBroj : listaDobitnihBrojeva){
            for(Integer pogodjenBroj : korisnik.getMojiBrojevi()){
                if(Objects.equals(izvucenBroj, pogodjenBroj)){
                    pogodjeniBrojevi.add(pogodjenBroj);
                }
            }
        }
    }

    // Metoda za dobijanje liste brojeva koje je korisnik pogodio
    public ArrayList<Integer> getDobitneProjeve(){
        return pogodjeniBrojevi;
    }

    // Metoda za postavljanje nagrade koju je korisnik osvojio
    public void setNagrada(double nagrada) {
        this.nagrada = nagrada;
    }

    // Metoda za dobijanje nagrade koju je korisnik osvojio
    public double getNagrada() {
        return nagrada;
    }

    // Metoda za dobijanje trenutnog korisnika
    public static Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    // Metoda za postavljanje trenutnog korisnika
    public static void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        Korisnik.trenutniKorisnik = trenutniKorisnik;
    }

    // Getter i setter za broj pogodjenih brojeva
    public int getBrojPogodjenihBrojeva() {
        return brojPogodjenihBrojeva;
    }

    public void setBrojPogodjenihBrojeva(int pogodjeniBrojevi) {
        this.brojPogodjenihBrojeva = pogodjeniBrojevi;
    }

    // Getter i setter za opkladu korisnika
    public int getOpklada() {
        return opklada;
    }

    public void setOpklada(int opklada) {
        this.opklada = opklada;
    }

    // Getter za listu brojeva koje je korisnik odabrao
    public ArrayList<Integer> getMojiBrojevi() {
        return mojiBrojevi;
    }
}
