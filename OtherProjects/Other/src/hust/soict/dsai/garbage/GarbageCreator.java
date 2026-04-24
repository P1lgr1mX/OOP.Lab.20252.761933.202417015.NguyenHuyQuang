package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.exe"; // Thay bằng đường dẫn file thực tế của bạn
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char)b; // Mỗi lần cộng chuỗi là một lần tạo object mới -> RÁC
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
