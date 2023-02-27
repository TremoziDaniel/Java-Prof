package homeWork29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    public static final int SERVER_PORT = 2048;
    public static final String SERVER_IP = "localhost";

    private List<ClientHandler> clients;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {
        int clientCount = 0;
        clients = new ArrayList<>();
        System.out.println("Server started...");
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = server.accept();
                String name = "Client#" + (++clientCount);
                ClientHandler client = new ClientHandler(socket, name);
                clients.add(client);
                new Thread(client).start();
                System.out.println(name + ": joined.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToAll (String message) {
        for (ClientHandler client : clients) {
            client.send(message);
        }
    }

    private void sendToAll (String name, String message, String exceptName) {
        for (ClientHandler client : clients) {
            if (!exceptName.equals(client.name)) {
                client.send(name + ": " + message);
            }
        }
    }

    private void privateSend (String name, String message, String toClient) {
        for (ClientHandler client : clients) {
            if (toClient.equals(client.name)) {
                client.send(name + "(private): " + message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private BufferedReader reader;
        private PrintWriter writer;
        private Socket socket;
        private String name;
        private Boolean presence;

        public ClientHandler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
            this.presence = true;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(String message) {
            writer.println(message);
            writer.flush();
        }

        public void runCommands(String name, String message) {
            message = message.replaceFirst("/", "");
            String commandSection = message.split(" ")[0];
            String operateSection1 = name;
            String operateSection2 = "";
            try {
                operateSection1 = message.split(" ")[1];
                operateSection2 = message.replaceFirst(commandSection, "")
                        .replaceFirst(" " + operateSection1, "");
            } catch (IndexOutOfBoundsException e) {

            }
            switch (commandSection.toLowerCase()) {
                case "exit":
                    send("/exit");
                    this.presence = false;
                    sendToAll(name, "disconnected", name);
                    break;
//                case "kick":
//                    send("exit");
//                    sendToAll(name, "kicked", name);
//                    break;
                case "rename":
                    for (ClientHandler client : clients) {
                        if (name.equals(client.name) && !name.equals(operateSection1)) {
                            client.name = operateSection1;
                            this.name = operateSection1;
                            clients.set(clients.indexOf(client), client);
                            sendToAll(name + " renamed to " + operateSection1);
                        }
                    }
                    break;
                case "getall":
                    send(clients.toString());
                    break;
                case "private":
                    privateSend(name, operateSection2, operateSection1);
                    break;
                case "help":
                    send("/exit - disconnect from server\n" +
                            "/rename [name] - renames client\n" +
                            "/getAll - gives list of clients\n" +
                            "/private [name] - send private message to client");
                    break;
                default:
                    send("Write /help to get list of commands.");
            }
        }

        @Override
        public void run() {
            String message;
            try {
                do {
                    message = reader.readLine();
                    if (message.charAt(0) == '/') {
                        runCommands(name, message);
                    }
//                    if (message.equals("exit")) {
//                        send(message);
//                        sendToAll(name, "disconnected");
//                    }
                    else {
                        sendToAll(name, message, name);
                    }
                    System.out.println(name + ": " + message);
                } while (presence);
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clients.remove(this);
            System.out.println(name + ": disconnected.");
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
