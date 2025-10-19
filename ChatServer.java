/**
 * 
 */
package Chatapp;

/**
 * 
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Chat server started on port 12345...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New user connected: " + clientSocket.getInetAddress());

                ClientHandler handler = new ClientHandler(clientSocket);
                clientHandlers.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all clients
    public static void broadcast(String message, ClientHandler excludeUser) {
        for (ClientHandler client : clientHandlers) {
            if (client != excludeUser) {
                client.sendMessage(message);
            }
        }
    }

    // Remove disconnected client
    public static void removeClient(ClientHandler client) {
        clientHandlers.remove(client);
    }
}

// Handles communication with each client
class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your name: ");
            name = in.readLine();
            ChatServer.broadcast(name + " joined the chat!", this);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(name + ": " + message);
                ChatServer.broadcast(name + ": " + message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ChatServer.removeClient(this);
                ChatServer.broadcast(name + " left the chat.", this);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Send message to this client
    public void sendMessage(String message) {
        out.println(message);
    }
}
