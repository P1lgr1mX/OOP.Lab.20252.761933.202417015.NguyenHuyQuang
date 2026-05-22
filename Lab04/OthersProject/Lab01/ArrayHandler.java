import java.util.Arrays;
import java.util.Scanner;

public class ArrayHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }


        Arrays.sort(arr);

        double sum = 0;
        for (double x : arr) {
            sum += x;
        }
        double average = sum / n;

        System.out.println("--- Kết quả ---");
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
        System.out.println("Tổng các phần tử: " + sum);
        System.out.printf("Trung bình cộng: %.2f\n", average);        
        sc.close();
    }
}
