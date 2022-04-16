package fwh;

import java.io.FileOutputStream;
import java.io.IOException;


public class Main {

    static int record = 0;

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public static int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    public static void printFlag() {

    }

    //public static native void write(int b, boolean append) throws IOException;
    //private native void writeBytes(byte b[], int off, int len, boolean append) throws IOException;

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Hello Phosphor");


//        int a = 2;
//        int b = a + 1;
//        int c = mul(a, b);
//        record = c;
//        System.out.println(c);
//        System.out.println(mul(b,c));
//        FileOutputStream outputStream = new FileOutputStream("/home/fengwenhan/data/phosphor_test/test_out/1.txt");
//        outputStream.write(54); //ASCII for 6

//        String hello = "hello";
//        outputStream.write(hello.getBytes());

//        Thread.sleep(20000);


//        StringBuilder s;
//
//        System.out.println("debug test");
//        System.out.println("debug test twice");

        Thread thread = new SocketServer(12001);
        thread.start();

        Thread.sleep(1000);

        SocketCilent client = new SocketCilent();
        client.startConnection("127.0.0.1", 12001);

        printFlag();


    }
}
