package org.example;

import java.io.IOException;
import java.net.*;

public class ServerAnivå {

    public static int port = 1234;
    public static InetAddress host;
    public static InetAddress group;

    static {
        try {
            group = InetAddress.getByName("225.4.5.6");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    MulticastSocket mltiCastSocket = new MulticastSocket(port);

    public ServerAnivå() throws IOException {
        runServer();
    }

    public int add(int int1, int int2){
        int result = int1+int2;
        return result;
    }
    public int sub(int int1, int int2){
        int result = int1-int2;
        return result;
    }
    public int mult(int int1, int int2){
        int result = int1*int2;
        return result;
    }


    public void runServer() throws IOException {

        mltiCastSocket.joinGroup(group);
        byte[] buf = new byte[1024];

        while(true){
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            mltiCastSocket.receive(data);
            String strData = new String(data.getData()).trim();

            if(strData.contains("+")){
                int tal1 = Integer.parseInt(strData.substring(0, strData.indexOf("+")));
                int tal2 = Integer.parseInt(strData.substring((strData.indexOf("+")+1)));
                System.out.println(tal1 + " " + tal2);
                Integer result = add(tal1,tal2);
                String resultString = String.valueOf(result);
                System.out.println("Resultat: " + resultString);
                DatagramPacket dataSent = new DatagramPacket(resultString.getBytes(),resultString.length(), 0,  group, port );
                mltiCastSocket.send(dataSent);
                System.out.println("data sent to client.");
                break;
            }
            else if(strData.contains("-")){
                int tal1 = Integer.parseInt(strData.substring(0, (strData.indexOf("-")-1)));
                int tal2 = Integer.parseInt(strData.substring((strData.indexOf("-")+1), (strData.length()+1)));
                System.out.println("tal 1: "+tal1+ ", tal2 : "+tal2);
                Integer result = sub(tal1,tal2);
                String resultString = String.valueOf(result);
                System.out.println("Resultat: " + resultString);
                DatagramPacket dataSent = new DatagramPacket(resultString.getBytes(), resultString.length(), 0,  group, port);
                mltiCastSocket.send(dataSent);
                System.out.println("data sent to client.");
                break;
            }
            else if(strData.contains("*")){
                int tal1 = Integer.parseInt(strData.substring(0, strData.indexOf("*")));
                int tal2 = Integer.parseInt(strData.substring((strData.indexOf("*")+1), (strData.length()+1)));
                Integer result = mult(tal1,tal2);
                String resultString = String.valueOf(result);
                System.out.println("tal 1: "+tal1+ ", tal2 : "+tal2);
                DatagramPacket dataSent = new DatagramPacket(resultString.getBytes(), resultString.length(), 0, group, port);
                mltiCastSocket.send(dataSent);
                System.out.println("data sent to client.");
                break;
            }
        }


/*
        mltiCastSocket.joinGroup(group);
        DatagramPacket datagramPacket = mltiCastSocket.receive();



 */

    }

    public static void main(String[] args) throws IOException {
        ServerAnivå serverAnivå = new ServerAnivå();
    }
}
