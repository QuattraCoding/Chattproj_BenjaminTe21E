package org.example;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class ClientAnivå {


    MulticastSocket multicastSocket;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    byte[] buf = new byte[1024];
    DatagramPacket additionData;
    DatagramPacket subtractionData;
    DatagramPacket multiplicationData;
    String previousmsg;

    public ClientAnivå() throws IOException {
        runClient();
    }



    public void runClient() throws IOException {

        multicastSocket = new MulticastSocket(ServerAnivå.port);
        multicastSocket.joinGroup(ServerAnivå.group);

        System.out.println("Välj addition med 1, subtraction med 2, multiplikation med 3");

        int choice = Integer.parseInt(br.readLine());

        switch(choice){
            case 1 ->{

                System.out.println("Skriv in nummer som du vill addera med ett plus emellan (+): ");
                String msg = br.readLine();
                previousmsg= msg;
                do{
                    if(msg.contains("+") && !msg.matches("\\D+")){
                        additionData = new DatagramPacket(msg.getBytes(), 0, msg.length(), ServerAnivå.group, ServerAnivå.port);
                        System.out.println("skickar tal till servern...");
                        multicastSocket.send(additionData);
                        break;
                    }
                    else {
                        System.out.println("Skriv in nummer som du vill addera med ett plus emellan (+): ");
                        msg = br.readLine();
                    }
                }while(true);




            }
            case 2 ->{
                System.out.println("Skriv in nummer som du vill subtrahera med ett minus emellan (-): ");
                String msg = br.readLine();
                do{
                    if(msg.contains("-") && !msg.matches("\\D+")){
                        subtractionData = new DatagramPacket(msg.getBytes(), 0, msg.length(), ServerAnivå.group, ServerAnivå.port);
                        System.out.println("skickar tal till servern...");
                        multicastSocket.send(subtractionData);
                        break;
                    }
                    else {
                        System.out.println("Skriv in nummer som du vill addera med ett plus emellan (+): ");
                        msg = br.readLine();
                    }
                }while(true);

            }
            case 3 ->{
                System.out.println("Skriv in nummer som du vill multiplicera med en stjärna emellan (*): ");
                String msg = br.readLine();

                do{
                    if(msg.contains("*") && !msg.matches("\\D+")){
                        multiplicationData = new DatagramPacket(msg.getBytes(), 0, msg.length(), ServerAnivå.group, ServerAnivå.port);
                        System.out.println("skickar tal till servern...");
                        multicastSocket.send(multiplicationData);

                        break;
                    }
                    else {
                        System.out.println("Skriv in nummer som du vill addera med ett plus emellan (+): ");
                        msg = br.readLine();
                    }
                }while(true);

            }
            default -> {
                runClient();
            }
        }

        while(true){

            byte[] buf = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            multicastSocket.receive(data);
            System.out.println("Data received. " + data.getData());
            String dataGot = new String(data.getData()).trim();
            System.out.println(dataGot);
            if (!previousmsg.equals(dataGot)){
            //Integer dataReceived = Integer.parseInt(dataGot);
            System.out.println("Svaret är : " + dataGot);
            break;}
            else{
                System.out.println("same mess");
            }

        }
        /*

        multicastSocket.joinGroup(ServerAnivå.group);
        System.out.println("1 for addition, 2 for subtraction, 3 for multiplication");
        switch (br.readLine()){
            case 1 -> multicastSocket.send(additionData);
            case 2 -> multicastSocket.send(subtractionData);
            case 3 -> multicastSocket.send(multiplicationData);
            default -> runClient();
        */
        }



    public static void main(String[] args) throws IOException {
        ClientAnivå clientAnivå = new ClientAnivå();
    }
}

