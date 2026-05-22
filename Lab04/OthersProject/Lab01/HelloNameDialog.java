import java.util.Scanner;

public class HelloNameDialog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String result = scanner.nextLine();
        System.out.println("Hi " + result + "!");
        scanner.close();
    }
}
