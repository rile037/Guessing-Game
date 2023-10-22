import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Klijent {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("Povezani ste na server.");

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Slanje podataka serveru
            String message = "Ovo je poruka od klijenta";
            output.write(message.getBytes());

            // Čitanje odgovora od servera
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Odgovor od servera: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
