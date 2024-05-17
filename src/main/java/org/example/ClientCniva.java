package org.example;

import java.io.*;
import java.net.*;

public class ClientCniva {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InetAddress host = InetAddress.getLocalHost();

    public ClientCniva() throws IOException, ClassNotFoundException, InterruptedException {
        runClient();
    }

    public void runClient() throws IOException, ClassNotFoundException, InterruptedException {

        MulticastSocket chatMulticastSocket = new MulticastSocket(ServerCniva.port);

        chatMulticastSocket.joinGroup(ServerCniva.group);
        String msg = "";
        System.out.println("type a message for the server: ");
        msg = br.readLine();

        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), ServerCniva.group, ServerCniva.port);
        chatMulticastSocket.send(data);

        chatMulticastSocket.close(); }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        new ClientCniva();
    }
}
