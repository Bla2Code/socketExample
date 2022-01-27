package ru.coderiders;

import java.io.IOException;

public class Connection {

    public static void main(String[] args) {
        PingClient client = new PingClient();
        try {
            client.startClient("127.0.0.1", 9090);
            String response;
            response = client.sendMessage("!ping");
            System.out.println(response);
        } catch (IOException e) {
            //Opps...
            System.out.println(e.getMessage());
        }
    }
}