package GestioneConcerto.Socket;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("In ascolto sulla porta 6666!");

            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Client Connesso!");

            int n1, n2;
            String o;

            //dout.writeUTF("Inserisci il primo numero: ");
            n1 = din.readInt();
            System.out.println("n1 ricevuto!");

            //dout.writeUTF("Inserisci il secondo numero: ");
            n2 = din.readInt();
            System.out.println("n2 ricevuto!");

            //dout.writeUTF("Inserisci l'operatore: ");
            o = din.readUTF().trim();
            System.out.println("operatore ricevuto!");

            switch (o){
                case "+":
                    dout.writeUTF(n1 + " + " + n2 + " = " + (n1+n2));
                    break;
                case "-":
                    dout.writeUTF(n1 + " - " + n2 + " = " + (n1-n2));
                    break;
                case "/":
                    dout.writeUTF(n1 + " / " + n2 + " = " + (n1/n2));
                    break;
                case "*":
                    dout.writeUTF(n1 + " * " + n2 + " = " + (n1*n2));
                    break;
                default:
                    dout.writeUTF("Errore: bisogna inserire un operatore valido");
            }
            ss.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


}
