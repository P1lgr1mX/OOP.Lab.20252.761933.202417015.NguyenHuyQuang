import java.util.Scanner;

public class MonthDaysDisplay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = -1;
        int year = -1;

        while (true) {
            System.out.print("Nhập tháng (Tên đầy đủ, viết tắt, hoặc số): ");
            String monthInput = scanner.nextLine().trim();
            month = getMonthNumber(monthInput);

            System.out.print("Nhập năm (số nguyên không âm, ví dụ 2024): ");
            String yearInput = scanner.nextLine().trim();
            year = parseYear(yearInput);

            if (month != -1 && year != -1) {
                int days = getDaysInMonth(month, year);
                System.out.println("Tháng " + monthInput + " năm " + year + " có " + days + " ngày.");
                break; // Thoát vòng lặp khi nhập đúng
            } else {
                System.out.println("Đầu vào không hợp lệ. Vui lòng thử lại!\n");
            }
        }
        scanner.close();
    }

    private static int getMonthNumber(String input) {
        input = input.toLowerCase().replace(".", "");
        switch (input) {
            case "january": case "jan": case "1": return 1;
            case "february": case "feb": case "2": return 2;
            case "march": case "mar": case "3": return 3;
            case "april": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun": case "6": return 6;
            case "july": case "jul": case "7": return 7;
            case "august": case "aug": case "8": return 8;
            case "september": case "sep": case "9": return 9;
            case "october": case "oct": case "10": return 10;
            case "november": case "nov": case "11": return 11;
            case "december": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    private static int parseYear(String input) {
        try {
            int y = Integer.parseInt(input);
            return (y >= 0) ? y : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }
}
