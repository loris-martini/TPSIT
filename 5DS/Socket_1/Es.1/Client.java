
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hostname = "localhost";
        int port = 6666;
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connesso al server " + hostname + " sulla porta " + port);

            System.out.println("inserisci il testo da inviare al server: ");
            String frase = input.nextLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(frase);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fraseFinale = in.readLine();
            System.out.println("La frase ricevuta dal server in uppercase è: " + fraseFinale);


        } catch (IOException e) {
            System.out.println("Errore nella connessione al server: " + e.getMessage());
        }
    }
}