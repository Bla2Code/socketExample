package ru.coderiders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PongServer {

    public void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String greeting = in.readLine();
        if ("!ping".equals(greeting)) {
            out.println("!pong");
        }
    }

    public static void main(String[] args) {
        PongServer server = new PongServer();
        try {
            server.startServer(9090);
        } catch (IOException e) {
            //Opps...
            System.out.println(e.getMessage());
        }
    }
}
