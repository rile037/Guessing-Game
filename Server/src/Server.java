import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Postavljanje porta na kojem ce server slusati

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server je pokrenut i sluša na portu " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Prihvata dolaznu vezu od klijenta
                System.out.println("\nNovi klijent povezan: " + clientSocket.getInetAddress());

                // Kreiranje nove niti za svakog klijenta
                Thread clientThread = new Thread(() -> {
                    try {
                        InputStream input = clientSocket.getInputStream(); // Ulazni tok podataka od klijenta
                        OutputStream output = clientSocket.getOutputStream(); // Izlazni tok podataka prema klijentu

                        Igra igra = new Igra(); // Kreiranje instance igre

                        // Ispisivanje izvučenih brojeva iz igre
                        System.out.println("\n\nIzvuceni brojevi: ");
                        for (Integer izvucenBroj : igra.getIzvuceniBrojevi()) {
                            System.out.print(izvucenBroj + ", ");
                        }

                        // Slanje liste izvučenih brojeva nazad klijentu
                        ObjectOutputStream objZaSlanje = new ObjectOutputStream(clientSocket.getOutputStream());
                        ArrayList<Integer> listaDobitnihBrojeva = igra.getIzvuceniBrojevi();
                        objZaSlanje.writeObject(listaDobitnihBrojeva);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close(); // Zatvaranje veze sa klijentom
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientThread.start(); // Pokretanje niti za komunikaciju sa klijentom
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
