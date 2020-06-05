package io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.DriverManager;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        //Socket socket1 = new Socket("127.0.0.1", 8081);
        //Class.forName("")

        OutputStream out = socket.getOutputStream();

        out.write("aa||".getBytes());
        out.write("bb".getBytes());
    }
}
