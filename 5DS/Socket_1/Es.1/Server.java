
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 6666; // Porta su cui il server ascolterà

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server in ascolto sulla porta " + port);

            while (true) {
                // Attende una connessione dal client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connesso: " + clientSocket.getInetAddress());

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String frase = in.readLine();
                    System.out.println("Frase ricevuta dal client: " + frase);
                    frase = frase.toUpperCase();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(frase);
                } catch (IOException e) {
                    System.out.println("Errore nella lettura dei dati dal client: " + e.getMessage());
                }


                // Chiude la connessione con il client e torna ad aspettare una nuova connessione
                clientSocket.close();
            }

        } catch (IOException e) {
            System.out.println("Errore nella creazione del server: " + e.getMessage());
        }
    }
}