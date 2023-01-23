package lesson19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeWork19 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("char_file.txt"), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // log error
        }
        try {
            Files.lines(Paths.get("char_file.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            // log error
        }
    }
}
