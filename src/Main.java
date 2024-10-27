import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        double x;
        double y;
        double z = 0;
        String xFormat;
        String yFormat;
        String result;
        char operator;
        String answer = "n";
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.#######");

        do {
            if (answer.equals("y")) {
                x = z;
            } else {
                System.out.print("Please enter your first number: ");
                x = Double.parseDouble(scanner.nextLine());
            }
            System.out.print("What operation would you like to perform?: ");
            operator = scanner.nextLine().charAt(0);
            System.out.print("Please enter your second number: ");
            y = Double.parseDouble(scanner.nextLine());
            if (operator == '/' && y == 0) {
                System.out.println("Cannot divide my zero. \n");
            } else {
                z = switch (operator) {
                    case '+' -> addition(x, y);
                    case '-' -> subtraction(x, y);
                    case '*' -> multiplication(x, y);
                    case '/' -> division(x, y);
                    default -> z;
                };
                xFormat = df.format(x);
                yFormat = df.format(y);
                result = df.format(z);
                System.out.println(xFormat + " " + operator + " " + yFormat + " = " + result + "\n");
                System.out.println("Would you like to reuse your answer?(y/n): ");
                answer = scanner.nextLine();
            }
        } while (true);
    }

    static double addition(double x, double y) {
        return x + y;
    }

    static double subtraction(double x, double y) {
        return x - y;
    }

    static double multiplication(double x, double y) {
        return x * y;
    }

    static double division(double x, double y) {
        return x / y;
    }
}
