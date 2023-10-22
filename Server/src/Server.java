import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server je pokrenut i sluša na portu " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novi klijent povezan: " + clientSocket.getInetAddress());

                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    String receivedData = new String(buffer, 0, bytesRead);
                    System.out.println("Primljeno od klijenta: " + receivedData);

                    // Ovde možete obraditi podatke i poslati odgovor nazad klijentu

                    // Primer odgovora
                    String response = "Odgovor od servera";
                    output.write(response.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
