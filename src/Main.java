import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int pogodjeni;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Korisnik korisnik = new Korisnik();
        System.out.println("Unesite opkladu: ");
        korisnik.setOpklada(scanner.nextInt());
        System.out.println("Unesite 6 vasih brojeva (Raspon: 1 - 46): ");
        while(korisnik.getMojiBrojevi().size() != 6) {
            try {
                if (scanner.hasNextInt()) {
                    int broj = scanner.nextInt();
                    if (broj <= 46 && broj >= 1) {
                        korisnik.dodajBroj(broj);
                        System.out.println("[" + korisnik.getMojiBrojevi().size() + "/6]");
                    } else {
                        System.out.println("- Greska, broj nije u opsegu");
                    }
                }
                else{
                    System.out.println("- Greska, niste uneli broj");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("- Greska, niste uneli broj");
                scanner.next();
            }
        }
//        System.out.println("Vasi brojevi: ");
//        for (Integer broj : korisnik.getMojiBrojevi()) {
//            System.out.println(broj);
//        }

        Igra igra = new Igra();
        Igra.Nagrada nagrada = new Igra.Nagrada();

        pogodjeni = 0;

        for(Integer izvucenBroj : igra.getIzvuceniBrojevi()){
            for(Integer broj : korisnik.getMojiBrojevi()){
                if(izvucenBroj.equals(broj)){
                    pogodjeni++;
                }
            }
            korisnik.setBrojPogodjenihBrojeva(pogodjeni);
        }
        Korisnik.dodajDobitneBrojeve(igra,korisnik);
        System.out.println("Vasi brojevi: ");
        for (Integer broj : korisnik.getMojiBrojevi()) {
            System.out.print(broj + ", ");
        }
        System.out.println("\n\nIzvuceni brojevi: ");
        for(Integer izvucenBroj : igra.getIzvuceniBrojevi()){
            System.out.print(izvucenBroj + ", ");
        }
        System.out.println("\n\nPogodili ste ukupno " + korisnik.getBrojPogodjenihBrojeva() + " broja od 20 izvucenih brojeva.");
        System.out.print("\n- Dobitni brojevi: ");
        for(Integer broj : korisnik.getDobitneProjeve()){
            System.out.print(broj + ", ");
        }
        System.out.println("\n");
        nagrada.dodeliNagradu(korisnik);
    }
}
