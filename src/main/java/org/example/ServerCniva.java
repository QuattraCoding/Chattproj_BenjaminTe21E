package org.example;

import java.io.IOException;
import java.net.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerCniva {
    public static int port = 12345;
    public static InetAddress group;

    static {
        try {
            group = InetAddress.getByName("225.4.5.6");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public ServerCniva() throws IOException, ClassNotFoundException {
        runServer();
    }

    public void runServer() throws IOException, ClassNotFoundException {

        MulticastSocket serverMulticastSocket = new MulticastSocket(port);

        serverMulticastSocket.joinGroup(group);
        System.out.println("Joingroup method is called.");

        while (true) {
            byte buf[] = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);

            String msg = new String(data.getData()).trim();
            System.out.println("Message received from client: " + msg);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new ServerCniva();
    }
}
