package lesson18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson18 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c;
        try {
            c = div(a, b);
        } catch (ArithmeticException e) {
//            e.printStackTrace();
//            System.out.println("Error: / by Zero");
            throw new DividedByZeroException();
        }
        fileWriteRead();
        System.out.println("Application done.");
    }

    static int div(int a, int b) {
        return a / b;
    }

    static void fileWrite() throws IOException{
        FileWriter file = new FileWriter("text.txt");
        file.write("Hello\nJava");
        file.close();
    }

    static void fileWriteRead() {

        // writing to file
        try (FileWriter file = new FileWriter("text.txt")) {
            file.write("Hello\nJava");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // reading from file
        try (FileReader file = new FileReader("text.txt")) {
            int b;
            while ((b = file.read()) != -1)
                System.out.print((char)b);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
