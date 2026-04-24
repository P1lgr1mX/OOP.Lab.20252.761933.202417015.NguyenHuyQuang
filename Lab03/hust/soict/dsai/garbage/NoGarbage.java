package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            // Sử dụng StringBuffer thay vì +
            StringBuffer outputStringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                outputStringBuffer.append((char)b);
            }
            
            String outputString = outputStringBuffer.toString();
            endTime = System.currentTimeMillis();
            System.out.println("Processing time (NoGarbage): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error: Could not read file.");
        }
    }
}
