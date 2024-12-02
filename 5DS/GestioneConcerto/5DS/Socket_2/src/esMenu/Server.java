package Socket.src.esMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    private int port = 1234;
    private ServerSocket server = null;
    private Socket client = null;
    private DataInputStream dalClient;
    private DataOutputStream versoClient;
    private int[] ordine = new int[6];
    private int[] prezzi = new int[6];
    private Random random = new Random();

    public void attendi(){
        try{
            System.out.println("SERVER partito");
            server = new ServerSocket(port);

            client = server.accept();
            System.out.println("CLIENT CONNESSO \n");

            dalClient = new DataInputStream(client.getInputStream());
            versoClient = new DataOutputStream(client.getOutputStream());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void menu(){
        try{
            System.out.println("MENU");
            String menu = "MENU:\n" +
                    "1) Antipasto\n" +
                    "2) Primo\n" +
                    "3) Secondo\n" +
                    "4) Contorno\n" +
                    "5) Pizza\n" +
                    "6) Dessert";
            versoClient.writeUTF(menu);

            int sc = 0;
            do {
                versoClient.writeUTF("ordina: ");
                sc = dalClient.readInt();
                switch (sc){
                    case 1:
                        ordine[0]++;
                        versoClient.writeUTF("Ordine preso!");
                        break;
                    case 2:
                        ordine[1]++;
                        versoClient.writeUTF("Ordine preso!");
                        break;
                    case 3:
                        ordine[2]++;
                        versoClient.writeUTF("Ordine preso!");
                        break;
                    case 4:
                        ordine[3]++;
                        versoClient.writeUTF("Ordine preso!");
                        break;
                    case 5:
                        ordine[4]++;
                        versoClient.writeUTF("Ordine preso!");
                        break;
                    case 6:
                        ordine[5]++;
                        versoClient.writeUTF("Ordine preso!");
                        break;
                    case 0:
                        versoClient.writeUTF("Ordine chiuso!");
                        break;
                    default:
                        versoClient.writeUTF("Ordine non valido!");
                }
            }while (sc != 0);
            String riepilogo = "RIEPILOGO ORDINE:" +
                    "\n1) Antipasto" + ordine[0] +
                    "\n2) Primo" + ordine[1] +
                    "\n3) Secondo" + ordine[2] +
                    "\n4) Contorno" + ordine[3] +
                    "\n5) Pizza" + ordine[4] +
                    "\n6) Dessert" + ordine[5];

            versoClient.writeUTF(riepilogo);

            for (int i = 0; i < prezzi.length; i++) {
                prezzi[i] = random.nextInt(5);
                System.out.println(i + ") " + prezzi[i] + "\n");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server S = new Server();
        S.attendi();
        S.menu();
    }
}
