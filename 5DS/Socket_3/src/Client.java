import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    String ipServer = "localhost"; //"10.0.75.21"
    int port = 5678;	          
    Socket mioSocket;		  
    DataOutputStream out;	
    DataInputStream in;          
    Scanner sc = new Scanner(System.in);

    public Socket connetti() {
        try {
            mioSocket = new Socket(ipServer, port);     			
            out = new DataOutputStream(mioSocket.getOutputStream());	
            in = new DataInputStream(mioSocket.getInputStream());        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mioSocket; 
    }

    public void comunica() {
        try {
            System.out.println("ciao provo a connettermi con il server...");
            int num;
            System.out.println(in.readUTF());
            for (int i = 0; i < 5; i++) {
                do {
                    System.out.println(in.readUTF());
                    sc = new Scanner(System.in);
                    num = sc.nextInt();
                    out.writeInt(num);
                } while (!in.readUTF().equalsIgnoreCase("OK"));
                System.out.println("Aggiunto!");
            }
            System.out.println("FINE");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        Client c = new Client();
        c.connetti();
        c.comunica();
    }
}
