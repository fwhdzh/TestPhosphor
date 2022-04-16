package fwh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread{

    private int port;

    public SocketServer(int port) {
        this.port = port;
    }


    public void startServer() throws IOException {
        startServer(port);
    }

    private void startServer(int port) throws IOException {
        System.out.println("The server waiting...");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("has connected to client");
        InputStream in= socket.getInputStream();
        byte[] buffer= new byte[100];
        int len = in.read(buffer);
        System.out.println(new String (buffer,0,len));
//        int len = -1;
//        while ((len = in.read(buffer)) != -1) {
//            System.out.println(new String (buffer,0,len));
//        }


        in.close();
//        clientSocket.close();
        socket.close();

    }

    @Override
    public void run() {
        super.run();
        try {
            startServer(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(12001);
        server.startServer();
//        Main.printFlag();
    }
}
