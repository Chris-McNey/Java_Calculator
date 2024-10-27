import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int x;
        int y;
        int z = 0;
        char operator;
        boolean doContinue = true;
        String answer = "n";

        do {
            Scanner scanner = new Scanner(System.in);
            if (Objects.equals(answer, "y")) {
                x = z;
            } else {
                System.out.print("Please enter your first number: ");
                x = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("What operation would you like to perform?: ");
            operator = scanner.nextLine().charAt(0);
            System.out.print("Please enter your second number: ");
            y = Integer.parseInt(scanner.nextLine());
            z = switch (operator) {
                case '+' -> addition(x, y);
                case '-' -> subtraction(x, y);
                case '*' -> multiplication(x, y);
                case '/' -> division(x, y);
                default -> z;
            };
            System.out.println(x + " " + operator + " " + y + " = " + z + "\n");
            System.out.println("Would you like to reuse your answer?(y/n): ");
            answer = scanner.nextLine();
        } while (doContinue);
    }

    static int addition(int x, int y) {
        return x + y;
    }
    static int subtraction(int x, int y) {
        return x - y;
    }
    static int multiplication(int x, int y) {
        return x * y;
    }
    static int division(int x, int y) {
        return x / y;
    }
}
