package Socket.src.esBomba;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    private int bomba;
    private int port = 1234;
    private ServerSocket server = null;
    private Socket client = null;
    private int puntClient = 0;
    private int puntServer = 0;
    private DataInputStream dalClient;
    private DataOutputStream versoClient;
    private Random random = new Random();

    public void attendi() {
        try {
            System.out.println("SERVER partito");
            server = new ServerSocket(port);
            client = server.accept();
            server.close();
            System.out.println("CLIENT CONNESSO \n");
            dalClient = new DataInputStream(client.getInputStream());
            versoClient = new DataOutputStream(client.getOutputStream());

            versoClient.writeUTF("Benvenuto, Client!\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server !");
            System.exit(1);
        }
    }

    public void gioca() {
        bomba = random.nextInt(501) + 500;
        while (true) {
            try {
                System.out.println("\nBomba = " + bomba);

                //Client
                puntClient = dalClient.readInt();
                System.out.println("Punteggio Client: " + puntClient);

                bomba -= puntClient;

                if(bomba <= 0){
                    versoClient.writeBoolean(false);
                    System.out.println("Client ha perso");
                    break;
                }

                //Server
                puntServer = random.nextInt(51) + 50;
                System.out.println("Punteggio Client: " + puntServer);

                bomba -= puntServer;

                if(bomba <= 0){
                    System.out.println("Client ha perso");
                    break;
                }

                System.out.println("Punteggio: " + (puntClient+puntServer));
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
        S.gioca();
    }
}

