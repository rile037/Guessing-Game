import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server je pokrenut i sluša na portu " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("\nNovi klijent povezan: " + clientSocket.getInetAddress());

                // Kreiranje nove niti za svakog klijenta
                Thread clientThread = new Thread(() -> {
                    try {
                        InputStream input = clientSocket.getInputStream();
                        OutputStream output = clientSocket.getOutputStream();

                        Igra igra = new Igra();
                        System.out.println("\n\nIzvuceni brojevi: ");
                        for(Integer izvucenBroj : igra.getIzvuceniBrojevi()){
                            System.out.print(izvucenBroj + ", ");
                        }
                        ObjectOutputStream objZaSlanje = new ObjectOutputStream(clientSocket.getOutputStream());
                        ArrayList<Integer> listaDobitnihBrojeva = new ArrayList<>();
                        listaDobitnihBrojeva = igra.getIzvuceniBrojevi();
                        objZaSlanje.writeObject(listaDobitnihBrojeva);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientThread.start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
