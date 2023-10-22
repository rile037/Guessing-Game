import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Korisnik {
    private ArrayList<Integer> mojiBrojevi = new ArrayList<Integer>();
    private static ArrayList<Integer> pogodjeniBrojevi = new ArrayList<>();

    private int idKorisnika;
    private int opklada;
    private int brojPogodjenihBrojeva = 0;
    private double nagrada = 0;

    public Korisnik(int idKorisnika){
        this.idKorisnika = idKorisnika;
        trenutniKorisnik = this;
    }


    // Getteri i setteri


    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public static void dodajDobitneBrojeve(ArrayList<Integer> listaDobitnihBrojeva, Korisnik korisnik){
        for(Integer izvucenBroj : listaDobitnihBrojeva){
            for(Integer pogodjenBroj : korisnik.getMojiBrojevi()){
                if(Objects.equals(izvucenBroj, pogodjenBroj)){
                    pogodjeniBrojevi.add(pogodjenBroj);
                }
            }
        }
    }

    public ArrayList<Integer> getDobitneProjeve(){
        return pogodjeniBrojevi;
    }


    public void setNagrada(double nagrada) {
        this.nagrada = nagrada;
    }

    public double getNagrada() {
        return nagrada;
    }

    public static Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public static void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        Korisnik.trenutniKorisnik = trenutniKorisnik;
    }

    private static Korisnik trenutniKorisnik;
    public int getBrojPogodjenihBrojeva() {
        return brojPogodjenihBrojeva;
    }



    public void setBrojPogodjenihBrojeva(int pogodjeniBrojevi) {
        this.brojPogodjenihBrojeva = pogodjeniBrojevi;
    }

    public int getOpklada() {
        return opklada;
    }

    public void setOpklada(int opklada) {
        this.opklada = opklada;
    }

    public ArrayList<Integer> getMojiBrojevi() {
        return mojiBrojevi;
    }

    public void dodajBroj(int broj) {
        mojiBrojevi.add(broj);
    }



}


