package GestioneConcerto.Socket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream d = new DataInputStream(s.getInputStream());
            Scanner input = new Scanner(System.in);

            int num1;
            int num2;
            String ris;
            String o;

            System.out.print("Inserire primo numero: ");
            num1 = input.nextInt();
            dout.writeInt(num1);

            System.out.print("Inserire secondo numero: ");
            num2 = input.nextInt();
            dout.writeInt(num2);

            System.out.print("Inserire l'operazione da eseguire: ");
            input = new Scanner(System.in);
            o = input.nextLine();
            dout.writeUTF(o);

            ris = d.readUTF();
            System.out.println(ris);

            s.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

}
