package org.example;

import java.io.IOException;
import java.net.*;

public class ServerAnivå {

    public static int port = 1234;
    public static InetAddress host;

    static {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static InetAddress group;

    static {
        try {
            group = InetAddress.getByName("255.4.5.6");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    MulticastSocket mltiCastSocket = new MulticastSocket(port);

    public ServerAnivå() throws IOException {
    }

    public int add(){


        return 0;
    }

    public void runServer() throws IOException {

        mltiCastSocket.joinGroup(group);
        DatagramPacket datagramPacket = mltiCastSocket.receive();



    }

    public static void main(String[] args) {

    }
}
