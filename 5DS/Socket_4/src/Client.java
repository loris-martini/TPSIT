import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private String ipServer = "localhost";
    private int port = 12345;
    private Socket mioSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public void connetti() {
        try {
            mioSocket = new Socket(ipServer, port);
            out = new DataOutputStream(mioSocket.getOutputStream());
            in = new DataInputStream(mioSocket.getInputStream());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comunica() {
        try {
            System.out.println("Connesso al server.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Client c = new Client();
        c.connetti();
        c.comunica();
    }
}
