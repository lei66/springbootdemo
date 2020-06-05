package io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8000);

        Socket socket = serverSocket.accept();
        System.out.println("------connect-----");
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        int len  = 0;
        while ((len = in.read(b)) != -1) {
            System.out.print(new String(b, 0, len));
        }
        System.out.println();

    }
}
