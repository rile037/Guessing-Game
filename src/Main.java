import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int pogodjeni; // Privatna promenljiva koja sadrzi broj pogodjenih brojeva

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // Inicijalizujemo objekat skener
        Korisnik korisnik = new Korisnik(); // Inicijalizujemo objekat korisnik


        while(korisnik.getOpklada() < 1){
            try{
                if(scanner.hasNextInt()){
                    korisnik.setOpklada(scanner.nextInt()); // Smestamo
                }else{
                    System.out.println("Opklada mora biti broj.");
                    scanner.next();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Greska");
            }
        }

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
