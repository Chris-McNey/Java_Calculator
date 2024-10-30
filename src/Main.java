import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String firstNum = "";
        String secondNum;
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
            try {
                if (answer.equals("y")) {
                    x = z;
                } else {
                    System.out.print("Please enter your first number: ");
                    firstNum = scanner.nextLine();
                    if (firstNum.endsWith("%")) {
                        x = Double.parseDouble(firstNum.substring(0, firstNum.length() - 1)) / 100;
                    } else {
                        x = Double.parseDouble(firstNum);
                    }
                }
                System.out.print("What operation would you like to perform?: ");
                operator = scanner.nextLine().charAt(0);
                System.out.print("Please enter your second number: ");
                secondNum = scanner.nextLine();
                if (secondNum.endsWith("%")) {
                    y = Double.parseDouble(secondNum.substring(0, secondNum.length() - 1)) / 100;
                } else {
                    y = Double.parseDouble(secondNum);
                }
                if (operator == '/' && y == 0) {
                    System.out.println("Cannot divide my zero. \n");
                } else {
                    z = switch (operator) {
                        case '+' -> {
                            if (secondNum.endsWith("%")) {
                                y *= x;
                            }
                            yield addition(x, y);
                        }
                        case '-' -> {
                            if (secondNum.endsWith("%")) {
                                y *= x;
                            }
                            yield subtraction(x, y);
                        }
                        case '*', 'x', 'X' -> multiplication(x, y);
                        case '/' -> division(x, y);
                        default -> z;
                    };
                }
                if (firstNum.endsWith("%")) {
                    xFormat = firstNum;
                } else {
                    xFormat = df.format(x);
                }
                if (secondNum.endsWith("%")) {
                    yFormat = secondNum;
                } else {
                    yFormat = df.format(y);
                }
                result = df.format(z);
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("That was an invalid operation. Please try again.");
                } else {
                    System.out.println(xFormat + " " + operator + " " + yFormat + " = " + result + "\n");
                    System.out.println("Would you like to reuse your answer?(y/n): ");
                    answer = scanner.nextLine();
                }
            } catch (NumberFormatException ignored) {
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
