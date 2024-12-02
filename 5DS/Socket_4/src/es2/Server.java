package es2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket serverSocket = new DatagramSocket(6789);
        boolean attivo=true;
        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];

        System.out.println("Server avviato...");

        while(attivo){
            DatagramPacket receivePacket= new DatagramPacket(bufferIN, bufferIN.length);
            serverSocket.receive(receivePacket);

            InetAddress IPClient = receivePacket.getAddress();
            int portaClient = receivePacket.getPort();

            String ricevuto = new String(receivePacket.getData());
            int numCaratteri = receivePacket.getLength();
            ricevuto = ricevuto.substring(0, numCaratteri);

            if(ricevuto.trim().isEmpty() || ricevuto == null){
                String errorMessage = "Errore: messaggio vuoto!";
                serverSocket.send(new DatagramPacket(errorMessage.getBytes(), errorMessage.length(), IPClient, portaClient));
                break;
            }

            if(!Pattern.compile("\\?$").matcher(ricevuto).find()){
                String errorMessage = "Non è una domanda!";
                serverSocket.send(new DatagramPacket(errorMessage.getBytes(), errorMessage.length(), IPClient, portaClient));
                break;
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            if(ricevuto.toLowerCase().equals("che ore sono?")){
                String daSpedire = ricevuto.toUpperCase() + " [" + formattedDateTime + "]";
                bufferOUT = daSpedire.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
            } else if (ricevuto.toLowerCase().equals("che giorno è oggi?")) {
                String daSpedire = ricevuto.toUpperCase() + " [" + formattedDateTime + "]";
                bufferOUT = daSpedire.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
            }

            System.out.println("Ricevuto: " + ricevuto);

            String daSpedire = ricevuto.toUpperCase() + " [" + formattedDateTime + "]";
            bufferOUT = daSpedire.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
            serverSocket.send(sendPacket);

            if(ricevuto.equals("fine")){
                System.out.println("server in chiusura. Arrivederci!");
                attivo=false;

            }

        }
        serverSocket.close();
    }
}