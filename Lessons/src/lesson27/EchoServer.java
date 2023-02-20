package lesson27;

import com.sun.security.ntlm.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        new EchoServer();
    }

    public EchoServer() {
        try (ServerSocket server = new ServerSocket(2048)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client Connected.");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String message = new String();
                do {
                    message = reader.readLine();
                    System.out.println("Client say: " + message);
                    writer.println("Echo: " + message);
                    writer.flush();
                } while (!message.equals("exit"));
                System.out.println("Client disconnected.");
                reader.close();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
