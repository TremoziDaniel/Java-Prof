package lesson15;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class SwingHashTable extends JFrame {
    private final int WIDTH_SIZE = 1024;
    private final int HEIGHT_SIZE = 600;
    private HashTable<String, String> hashT = new HashTable<>();

    public static void main(String[] args) {
        new SwingHashTable();
    }

    public SwingHashTable() {
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
            if (tokens[0].equals("put")){
                hashT.put(tokens[1], tokens[2]);
            }
            if (tokens[0].equals("remove")){
                hashT.remove(tokens[1]);
            }
            textField.setText("");
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

    private void initHashTable() {
        hashT.put("Kiev", "Ukraine");
        hashT.put("Krakow", "Poland");
        hashT.put("Paris", "France");
        hashT.put("Amsterdam", "Niderland");
        hashT.put("Moscow", "Russia");
        hashT.put("Warsaw", "Poland");
        hashT.put("Madrid", "Spain");
        hashT.remove("Krakow");
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            HashTable<String, String>.Entry<String, String>[] table = hashT.getTable();
            initHashTable();
            // TODO
            int x = 10;
            int y = 20;
            final int DX = 65;
            final int DY = 65;
            int xTemp = 0;
            int chain = 0;
            int maxChain = 0;
            for (int i = 0; i < hashT.getTable().length; i++) {
                if (x >= WIDTH_SIZE - 70) {
                    x = 10;
                    y = maxChain + 70;
                }
                if(table[i] != null){
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, DX, DY);
                    g.setColor(Color.BLACK);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(" ");
                    sb.append((String) table[i].key);
                    g.drawString(sb.toString(), x + 3, y + 25);
                    g.drawString((String) table[i].value, x + 3, y + 40);
                    String next = (table[i].next == null) ? "n->null" : "n->" + table[i].next.key;
                    g.drawString(next, x + 3, y + 55);
                    HashTable<String, String>.Entry<String, String> pointer = table[i];
                    chain = y;
                    while (pointer.next != null) {
                        chain += 70;
                        g.setColor(Color.CYAN);
                        g.fillRect(x, chain, DX, DY);
                        g.setColor(Color.BLACK);
                        StringBuilder sb1 = new StringBuilder();
                        sb1.append(i);
                        sb1.append(" ");
                        sb1.append((String) pointer.next.key);
                        g.drawString(sb1.toString(), x + 3, chain + 25);
                        g.drawString((String) pointer.next.value, x + 5, chain + 40);
                        String next2 = (pointer.next.next == null) ? "n-> null" : "n-> " + pointer.next.next.key;
                        g.drawString(next2, x + 3, chain + 55);
                        pointer = pointer.next;
                    }
                    if(chain > maxChain) {
                        maxChain = chain;
                    }
                } else {
                    g.setColor(Color.GRAY);
                    g.drawRect(x, y, DX, DY);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(i), x + 3, y + 25);
                }
                x += 70;
            }
        }
    }
}