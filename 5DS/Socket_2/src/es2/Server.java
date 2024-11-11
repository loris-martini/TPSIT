package Socket.src.es2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server = null;
    private Socket client = null;
    private String stringa = null;
    private DataInputStream dalClient;
    private DataOutputStream versoClient;

    public Socket attendi() {
        try {
            System.out.println("SERVER partito");
            server = new ServerSocket(6789);
            client = server.accept();
            server.close();
            System.out.println("CLIENT CONNESSO \n");
            dalClient = new DataInputStream(client.getInputStream());
            versoClient = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server !");
            System.exit(1);
        }
        return client;
    }

    public void comunica() {
        while (true) {
            try {
                System.out.println("...attesa...\n");
                stringa = dalClient.readUTF();
                System.out.println("RICEVO: " + stringa);
                if (stringa.equalsIgnoreCase("chiudi")) {
                    break;
                }
                System.out.println("RISPONDO: " + stringa + '\n');
                versoClient.writeUTF(stringa);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Errore");
            }
        }
        try {
            System.out.println("CHIUDO");
            client.close();
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Server S = new Server();
        S.attendi();
        S.comunica();
    }
}
