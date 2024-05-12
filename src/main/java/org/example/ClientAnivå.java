package org.example;

import java.io.*;
import java.net.*;
public class ClientAnivå {


    public MulticastSocket multicastSocket = new MulticastSocket(ServerAnivå.port);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    byte[] buf = new byte[1024];
    DatagramPacket additionData = new DatagramPacket(buf, 0, buf.length, ServerAnivå.host, ServerAnivå.port);
    DatagramPacket subtractionData = new DatagramPacket(buf, 0, buf.length, ServerAnivå.host, ServerAnivå.port);
    DatagramPacket multiplicationData = new DatagramPacket(buf, 0, buf.length, ServerAnivå.host, ServerAnivå.port);

    public ClientAnivå() throws IOException {
    }



    public void runClient() throws IOException {

        multicastSocket.joinGroup(ServerAnivå.group);
        System.out.println("1 for addition, 2 for subtraction, 3 for multiplication");
        switch (br.readLine()){
            case 1 -> multicastSocket.send(additionData);
            case 2 -> multicastSocket.send(subtractionData);
            case 3 -> multicastSocket.send(multiplicationData);
            default -> runClient();

        }

    }

    public static void main(String[] args) {

    }
}
