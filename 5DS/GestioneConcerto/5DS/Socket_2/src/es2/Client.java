package Socket.src.es2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private Socket miosocket;                                
    private BufferedReader tastiera;
    private String stringaUtente;
    private String stringaRicevuta;
    private DataOutputStream versoServer;
    private DataInputStream dalServer;

    public Socket connetti() {
        System.out.println("CLIENT partito" + '\n');
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket("localhost", 6789);
            versoServer = new DataOutputStream(miosocket.getOutputStream());
            dalServer = new DataInputStream(miosocket.getInputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
        }
        return miosocket;
    }

    public void comunica() {
        while (true) {
            try {
                System.out.println("INSERISCI UN STRINGA:");
                stringaUtente = tastiera.readLine();
                versoServer.writeUTF(stringaUtente);
                if (stringaUtente.equals("chiudi")) {
                    break;
                }
                stringaRicevuta = dalServer.readUTF();
                System.out.println(stringaRicevuta + '\n');
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Errore");
            }
        }
        try {
            System.out.println("CHIUDO");
            miosocket.close();
        } catch (IOException ex) {}
    }

    public static void main(String[] args) {
        Client C = new Client();
        C.connetti();
        C.comunica();
    }
}
