package es2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) throws SocketException, IOException {

        int portaServer = 6789;
        InetAddress IPServer = InetAddress.getByName("localhost");

        byte[] bufferOUT = new byte[1024];
        byte[] bufferIN = new byte[1024];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();
        System.out.println("Client pronto");
        System.out.println("Inserisci il messaggio: ");

        String daSpedire = input.readLine();
        bufferOUT = daSpedire.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPServer, portaServer);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
        clientSocket.receive(receivePacket);
        String ricevuto = new String(receivePacket.getData());

        int numCaratteri = receivePacket.getLength();
        ricevuto = ricevuto.substring(0, numCaratteri);
        System.out.println("dal server: " + ricevuto);

        clientSocket.close();
    }
}