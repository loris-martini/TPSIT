package Socket.src.esMenu;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private int port = 1234;
    private Socket miosocket;
    private DataOutputStream versoServer;
    private DataInputStream dalServer;

    public void connetti() {
        System.out.println("CLIENT partito");
        try {
            miosocket = new Socket("localhost", port);
            System.out.println("\nClient Connesso! con porta " + port);
            versoServer = new DataOutputStream(miosocket.getOutputStream());
            dalServer = new DataInputStream(miosocket.getInputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
        }
    }

    public static void main(String[] args) {

    }
}
