package org.example;

import java.io.*;
import java.net.*;

public class ServerEnivå {

    public static int port = 1234;

    static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ServerEnivå() throws IOException, ClassNotFoundException {
        runServer();
    }

    public void runServer() throws IOException, ClassNotFoundException {
        //create the socket server object
        //keep listens indefinitely until receives 'exit' call or program terminates
        while (true) {
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
            oos.writeObject("Hi Client " + message);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if (message.equalsIgnoreCase("exit")) break;

            /*

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

    }
    public static void main (String[]args) throws IOException, ClassNotFoundException {
        ServerEnivå serverEnivå = new ServerEnivå();

    }
}
