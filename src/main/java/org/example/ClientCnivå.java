package org.example;

import java.io.*;
import java.net.*;

public class ClientCnivå {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InetAddress host = InetAddress.getLocalHost();

    public ClientCnivå() throws IOException, ClassNotFoundException, InterruptedException {
        runClient();
    }

    public void runClient() throws IOException, ClassNotFoundException, InterruptedException {

        MulticastSocket chatMulticastSocket = new MulticastSocket(ServerEnivå.port);

        chatMulticastSocket.joinGroup(ServerCnivå.group);
        String msg = "";
        System.out.println("type a message for the server: ");
        msg = br.readLine();

        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), ServerCnivå.group, ServerCnivå.port);
        chatMulticastSocket.send(data);

        chatMulticastSocket.close(); }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        new ClientCnivå();
    }
}
