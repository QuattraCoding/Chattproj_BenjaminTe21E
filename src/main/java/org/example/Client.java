package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

    ObjectInputStream objectInputStream = null;
    ObjectOutputStream objectOutputStream = null;
    Socket socket = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InetAddress host = InetAddress.getLocalHost();

    public Client() throws UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
        runClient();
    }

    public void runClient() throws IOException, ClassNotFoundException, InterruptedException {



        /*

        KOD FÖR E-NIVÅ

        for(int i=0; i<5;i++){

            socket = new Socket(host.getHostName(), 9876);


            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            out.println("Sending request to Socket Server");
            out.println("Type bye to exit, Write what you want to send to the server: ");
            String message  = br.readLine();
            objectOutputStream.writeObject(message);



            objectInputStream = new ObjectInputStream(socket.getInputStream());
            message = (String) objectInputStream.readObject();
            out.println("Message: " + message);

            objectInputStream.close();
            objectOutputStream.close();
            Thread.sleep(100);
        }

        ------------------------------------------------------------------------------------------------------

            KOD SOM ANVÄNDES FRÅN BÖRJAN. INTE E-NIVÅ KODEN

        bufferedReader = null;
        bufferedWriter = null;
        socket = null;

        for (int i = 0; i<5; i++){



            socket = new Socket(host.getHostAddress(), 1234);

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("sending request to server");

            if (i==4){
                bufferedWriter.write("exit");
            }
            else{
                bufferedWriter.write(" "+i);
            }
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            System.out.println("message: " + message);

            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
            Thread.sleep(100);
        }
*/
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Client client = new Client();
    }
}
