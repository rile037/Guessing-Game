import java.util.ArrayList;

public class Korisnik {
    private ArrayList<Integer> mojiBrojevi = new ArrayList<Integer>();
    private static ArrayList<Integer> pogodjeniBrojevi = new ArrayList<>();
    private int opklada;
    private int brojPogodjenihBrojeva = 0;
    private double nagrada = 0;

    // Getteri i setteri

    public static void dodajDobitneBrojeve(Igra igra, Korisnik korisnik){
        for(Integer izvucenBroj : igra.getIzvuceniBrojevi()){
            for(Integer pogodjenBroj : korisnik.getMojiBrojevi()){
                if(izvucenBroj == pogodjenBroj){
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
    public Korisnik(){
        trenutniKorisnik = this;
    }
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
