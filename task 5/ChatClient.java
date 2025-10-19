package Chatapp;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Thread to read messages from server
            new Thread(() -> {
                String serverMsg;
                try {
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Main thread to send messages to server
            String userMsg;
            while ((userMsg = keyboard.readLine()) != null) {
                out.println(userMsg);
                if (userMsg.equalsIgnoreCase("exit")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
