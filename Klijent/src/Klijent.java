import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ObjectInputStream;

public class Klijent{
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        Scanner scanner = new Scanner(System.in); // Inicijalizujemo objekat skener
        Korisnik korisnik = new Korisnik(1);

        System.out.println("Unesite vasu opkladu u dinarima: ");
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

        System.out.println("\nVasi brojevi: ");
        for (Integer broj : korisnik.getMojiBrojevi()) {
            System.out.print(broj + ", ");
        }



        try (Socket socket = new Socket(serverAddress, serverPort)) {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();



            ObjectInputStream objZaPrimanje = new ObjectInputStream(socket.getInputStream());
                ArrayList<Integer> listaIzvucenihBrojeva = (ArrayList<Integer>) objZaPrimanje.readObject();
                System.out.println("\nIzvuceni brojevi: ");
                for (Integer broj : listaIzvucenihBrojeva) {
                    System.out.print(broj + ", ");
                }
            objZaPrimanje.close();

            int pogodjeni = 0;
            for(Integer izvucenBroj : listaIzvucenihBrojeva){
                for(Integer broj : korisnik.getMojiBrojevi()){
                    if(izvucenBroj.equals(broj)){
                        pogodjeni++;
                    }
                }
                korisnik.setBrojPogodjenihBrojeva(pogodjeni);
            }

            Korisnik.dodajDobitneBrojeve(listaIzvucenihBrojeva,korisnik);
            if(korisnik.getBrojPogodjenihBrojeva() < 1){
                System.out.println("\nNiste pogodili nijedan broj, vise srece drugi put!");
            }else{
                System.out.println("\n\nPogodili ste ukupno " + korisnik.getBrojPogodjenihBrojeva() + " broja od 20 izvucenih brojeva.");
                System.out.print("\n- Dobitni brojevi: ");
                for(Integer broj : korisnik.getDobitneProjeve()){
                    System.out.print(broj + ", ");
                }
                System.out.println("\n");
                Nagrada nagrada = new Nagrada();
                nagrada.dodeliNagradu(korisnik);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
