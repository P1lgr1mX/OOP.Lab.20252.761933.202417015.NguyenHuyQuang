import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String menu = "Chọn loại phương trình:\n" +
                      "1. Bậc nhất 1 ẩn (ax + b = 0)\n" +
                      "2. Hệ bậc nhất 2 ẩn\n" +
                      "3. Bậc hai 1 ẩn (ax^2 + bx + c = 0)";
        String choice = JOptionPane.showInputDialog(menu);

        if (choice.equals("1")) {
            solveLinear();
        } else if (choice.equals("2")) {
            solveSystem();
        } else if (choice.equals("3")) {
            solveQuadratic();
        }
        System.exit(0);
    }

    // 1. Phương trình bậc nhất
    static void solveLinear() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        if (a == 0) {
            JOptionPane.showMessageDialog(null, b == 0 ? "Vô số nghiệm" : "Vô nghiệm");
        } else {
            JOptionPane.showMessageDialog(null, "Nghiệm x = " + (-b / a));
        }
    }

    // 2. Hệ phương trình 2 ẩn (Cramer)
    static void solveSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "x1 = " + (D1 / D) + ", x2 = " + (D2 / D));
        } else {
            if (D1 == 0 && D2 == 0) JOptionPane.showMessageDialog(null, "Vô số nghiệm");
            else JOptionPane.showMessageDialog(null, "Vô nghiệm");
        }
    }

    // 3. Phương trình bậc hai
    static void solveQuadratic() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        if (a == 0) {
            // Quay lại giải pt bậc nhất
            if (b == 0) JOptionPane.showMessageDialog(null, c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
            else JOptionPane.showMessageDialog(null, "x = " + (-c / b));
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) JOptionPane.showMessageDialog(null, "Vô nghiệm thực");
            else if (delta == 0) JOptionPane.showMessageDialog(null, "Nghiệm kép x = " + (-b / (2 * a)));
            else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}
