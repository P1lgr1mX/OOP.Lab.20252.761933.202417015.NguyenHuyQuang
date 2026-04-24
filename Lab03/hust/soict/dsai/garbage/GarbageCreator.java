package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // Hãy copy 1 file exe hoặc file văn bản cực lớn vào cùng thư mục
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char)b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Processing time (GarbageCreator): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error: Could not read file. Make sure 'test.exe' exists.");
        }
    }
}
