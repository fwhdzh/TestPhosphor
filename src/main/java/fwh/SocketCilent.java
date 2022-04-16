package fwh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCilent {

    private Socket clientSocket;

    public void startConnection(String ip, int port) throws IOException {
        System.out.println("Client begin connect");
        clientSocket = new Socket(ip, port);
        if (!clientSocket.isConnected()) {
            System.out.println("Client connect fail");
            return;
        }
        System.out.println("Client connect success");
        OutputStream out = clientSocket.getOutputStream();
        String hello = "Hello";
        byte[] buffer= hello.getBytes();
        out.write(buffer);
        System.out.println("Client write finish");
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        SocketCilent client = new SocketCilent();
        client.startConnection("127.0.0.1", 12001);
    }


}
