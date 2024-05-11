package org.example;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    public static int port = 1234;

    /*
    variabler för C-nivå

    public static InetAddress group = InetAddress.getByName("255.4.5.6");
     */




    /*
    FÖR E-nivå koden

    static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

     Socket socket;

     BufferedReader bufferedReader;

     BufferedWriter bufferedWriter;

    } */

    public Server() throws IOException, ClassNotFoundException {
    runServer();
    }

    public void runServer() throws IOException, ClassNotFoundException {

        /*
        KOD FÖR C-NIVÅ, har fel. Kopierat precis från uppgiften.

        MulticastSocket serverMulticastSocket = new MulticastSocket(port);

        serverMulticastSocket.joinGroup(group);
        System.out.println("Joingroup method is called.");

        while(true){
            byte buf[] = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);

            String msg = new String(data.getData()).trim();
            System.out.println("Message received from client: " + msg);
        }

         -----------------------------------------------------------------------------------------------------------

                KOD FÖR E-NIVÅ

        //create the socket server object
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            Socket socket = serverSocket.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject("Hi Client "+message);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;

            ----------------------------------------------------------------------------------------------

            KOD SOM JAG FÖRSÖKTE MED FRÅN BÖRJAN. INTE E-NIVÅ

       System.out.println("waiting for client to connect");
        while(true){
            socket  = serverSocket.accept();

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            System.out.println("Message Received: " + message);

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("hi client" + message);

            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.reset();
            bufferedReader.close();
            socket.close();

            if (message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down server!");
        serverSocket.close();

        }
        // */


}

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();

    }
}
