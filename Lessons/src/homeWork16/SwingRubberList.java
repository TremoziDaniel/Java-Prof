package homeWork16;

import javax.swing.*;
import java.awt.*;

public class SwingRubberList extends JFrame {
    private final int WIDTH_SIZE = 1024;
    private final int HEIGHT_SIZE = 600;
    private RubberList<String> list = new RubberList<>("New Scotland",
            "New Brunswick", "Maine", "New Hampshire", "Vermont", "Massachusetts",
            "Rhode Island", "Connecticut", "New York", "Pennsylvania", "New Jersey",
            "Delaware", "Maryland", "Virginia", "West Virginia", "Ohio", "Michigan");

    public static void main(String[] args) {
        new SwingRubberList();
    }

    public SwingRubberList() {
        setTitle("HashTable");// Задать название окну
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Что бы закрыть все потоки свинга при закрытии окна

        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setPreferredSize(new Dimension(WIDTH_SIZE, HEIGHT_SIZE));
        canvasPanel.setBackground(Color.lightGray);

        JTextField textField = new JTextField("Write", 1);
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> {
            // TODO
            System.out.println("#: " + textField.getText());
            String[] tokens = textField.getText().split(" ");
            String result = "";
            if (tokens[0].equals("push")){
                list.push(result = textField.getText().replace(tokens[0] + " ", ""));
            }
            if (tokens[0].equals("pop")){
                result = list.pop();
            }
            if (tokens[0].equals("pull")){
                result = list.poll();
            }
            if (tokens[0].equals("remove")){
                list.remove(result = textField.getText().replace(tokens[0] + " ", ""));
            }
            textField.setText(result);
            canvasPanel.repaint();
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(enterButton);
        bottomPanel.add(textField);

        add(canvasPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            RubberList<String>.Node<String> linkedList = list.getFirstNode();
            // TODO
            int x = 10;
            int y = 20;
            final int DX = 80;
            final int DY = 80;
            String topic;
            while (linkedList != null) {
                if (x >= WIDTH_SIZE - 70) {
                    x = 10;
                    y += 90;
                }
                if (linkedList == list.getFirstNode()) {
                    g.setColor(Color.GREEN);
                    topic = "First";
                } else if(linkedList == list.getLastNode()) {
                    g.setColor(Color.YELLOW);
                    topic = "Last";
                } else {
                    g.setColor(Color.CYAN);
                    topic = ".next";
                }
                g.fillRect(x, y, DX, DY);
                g.setColor(Color.WHITE);
                g.drawRect(x, y, DX, DY);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Tahoma", Font.BOLD, 12));
                g.drawString(topic, x + 2, y + 15);
                g.setFont(new Font("Tahoma", Font.PLAIN, 12));
                g.drawString(linkedList.value, x + 2, y + 35);
                x += 90;
                linkedList = linkedList.next;
            }
        }
    }
}