import java.util.Scanner;

public class CalculateNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Double Calculator ---");
        
        System.out.print("Please input the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Please input the second number: ");
        double num2 = sc.nextDouble();

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Quotient: Cannot divide by zero!");
        }

        sc.close();
    }
}
