package Socket.src.esBomba;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;
public class Client {
    private int port = 1234;
    private Socket miosocket;
    private BufferedReader tastiera;
    private String stringaUtente;
    private String stringaRicevuta;
    private DataOutputStream versoServer;
    private DataInputStream dalServer;
    private Random random = new Random();

    public void connetti() {
        System.out.println("CLIENT partito" + '\n');
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket("localhost", port);
            System.out.println("Client Connesso! con porta " + port +"\n");
            versoServer = new DataOutputStream(miosocket.getOutputStream());
            dalServer = new DataInputStream(miosocket.getInputStream());

            System.out.println(dalServer.readUTF());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
        }
    }

    public void comunica() {
        while (true) {
            try {
                versoServer.writeInt(random.nextInt(51) + 50);

                if(dalServer.readBoolean()){
                    System.out.println("Hai perso!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Errore");
            }
        }
        try {
            System.out.println("CHIUDO");
            miosocket.close();
        } catch (IOException ex) {

        }
    }

    public static void main(String[] args) {
        Client C = new Client();
        C.connetti();
        C.comunica();
    }
}
