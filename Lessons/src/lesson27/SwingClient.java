package lesson27;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SwingClient extends JFrame {
    JTextArea dialogue;
    JTextField msgField;

    Socket socket;
    PrintWriter writer;
    BufferedReader reader;

    public static void main(String[] args) {
        new SwingClient();
    }

    public SwingClient() {
        setTitle("Client for network chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (writer != null) {
                    writer.println("exit");
                    try {
                        socket.close();
                        writer.close();
                        reader.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        dialogue.setEditable(false);
        JScrollPane scroll = new JScrollPane(dialogue);

        msgField = new JTextField();
        JButton connect = new JButton("CONNECT");
        JButton disconnect = new JButton("DISCONNECT");
        disconnect.setEnabled(false);
        JButton send = new JButton("SEND");
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(msgField);
        southPanel.add(send);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        northPanel.add(connect);
        northPanel.add(disconnect);

        send.addActionListener(l -> {
            String echo;
            try {
                writer.println(msgField.getText());
                writer.flush();
                echo = reader.readLine();
                dialogue.append(echo + "\n");
                msgField.setText(null);
                if(echo.equals("exit")) {
                    connect.setEnabled(true);
                }
            } catch (SocketException e) {
                System.out.println("Connection to server lost.");
                connect.setEnabled(true);
                disconnect.setEnabled(false);
                try {
                    socket.close();
                    reader.close();
                    writer.close();
                    writer.flush();
                } catch (IOException inE) {
                    inE.printStackTrace();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        add(BorderLayout.NORTH, northPanel);
        add(BorderLayout.CENTER, dialogue);
        add(BorderLayout.SOUTH, southPanel);
        setVisible(true);
        connect.addActionListener(b -> {
            try {
                connect();
                connect.setEnabled(false);
                disconnect.setEnabled(true);
            } catch (IOException e) {
                System.out.println("Can't connect to server");
            }
        });

        disconnect.addActionListener(b -> {
            try {
                writer.println("exit");
                writer.flush();
                socket.close();
                writer.close();
                reader.close();
                disconnect.setEnabled(false);
                connect.setEnabled(true);
                System.out.println("Disconnected from server.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void connect() throws IOException {
            socket = new Socket("localhost", 2048);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to server.");
    }
}
