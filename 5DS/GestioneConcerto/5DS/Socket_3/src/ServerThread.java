import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    Socket client;
    DataOutputStream out;
    DataInputStream in;
    static ArrayList<Integer> numeri = new ArrayList<>();

    public ServerThread(Socket c) {
        client = c;
    }

    @Override
    public void run() {
        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        comunica();
    }

    public void comunica() {
        try {
            out.writeUTF("Benvenuto utente.");

            for (int j = 0; j < 5; j++) {
                out.writeUTF("Inserisci un numero: ");
                int n = in.readInt();

                while (numeri.contains(n)) {
                    out.writeUTF("NO");
                    out.writeUTF("Inserisci nuovo numero, il precedente e' già presente. Numeri Inseriti: " + numeri.toString());
                    n = in.readInt();
                }
                out.writeUTF("OK");
                numeri.add(n);

                for (int i = 0; i < numeri.size(); i++) {
                    System.out.print(numeri.get(i) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
