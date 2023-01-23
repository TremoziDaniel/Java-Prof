package lesson19;

import java.io.*;

public class Lesson19 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.length());
        byteArrayStreamDemo();
        fileOutputStreamDemo();
        fileInputStreamDemo();
        fileWriterDemo();
        fileReadDemo();
    }

    static void byteArrayStreamDemo() {
        byte[] buffer = {66, 67, 68};
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        int x;
        while ((x = bais.read()) != -1) {
            System.out.print(x + " ");
        }
    }

    static void fileOutputStreamDemo() {
        byte[] buffer = {0x30, 0x31, 0x29};
        try (FileOutputStream fos = new FileOutputStream("byte_array.bin")) {
            fos.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileInputStreamDemo() {
        byte[] buffer = new byte[3];
        try (FileInputStream fis = new FileInputStream("byte_array.bin")) {
            fis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (byte b: buffer) {
            System.out.print("\n" + b + " = " + (char) b);

        }
    }

    static void fileWriterDemo() {
        try (FileWriter fw = new FileWriter("char_file.txt")) {
            fw.write("Hello dudes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileReadDemo() {
        char[] buffer = new char[50];
        try (FileReader fr = new FileReader("char_file.txt")) {
            fr.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + new String(buffer));
    }
}
