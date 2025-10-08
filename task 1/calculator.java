package demo;
import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Calculator ");
            System.out.println("1. Arithmetic Function");
            System.out.println("2. Scientific Functions");
            System.out.println("3. Unit Conversions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    arithmetic(sc);
                    break;
                case 2:
                    scientific(sc);
                    break;
                case 3:
                    unit(sc);
                    break;
                case 0:
                    System.out.println("Exit....Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    //  Arithmetic Function
    public static void arithmetic(Scanner sc) {
        System.out.print("Enter the first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double b = sc.nextDouble();

        System.out.println("Select Operation: + - * /");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Addition: " + (a + b));
                break;
            case '-':
                System.out.println("Subtraction: " + (a - b));
                break;
            case '*':
                System.out.println("Multiplication: " + (a * b));
                break;
            case '/':
                if (b != 0)
                    System.out.println("Division: " + (a / b));
                else
                    System.out.println("Error! Division by zero.");
                break;
            default:
                System.out.println("Invalid Operator!");
        }
    }

    //  Scientific Function
    public static void scientific(Scanner sc) {
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (a^b)");
        System.out.print("Enter the choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter number: ");
                double num = sc.nextDouble();
                if (num >= 0)
                    System.out.println("Square Root: " + Math.sqrt(num));
                else
                    System.out.println("Error! Cannot find square root of negative number.");
                break;

            case 2:
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = sc.nextDouble();
                System.out.println("Result: " + Math.pow(base, exp));
                break;

            default:
                System.out.println("Invalid choice!...Try again");
        }
    }

    // Unit Conversion
    public static void unit(Scanner sc) {
        System.out.println("1. Temperature (Celsius ↔ Fahrenheit)");
        System.out.println("2. Currency (USD ↔ INR)");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                int Ch = sc.nextInt();

                if (Ch == 1) {
                    System.out.print("Enter Celsius: ");
                    double c = sc.nextDouble();
                    double f = (c * 9 / 5) + 32;
                    System.out.println("Fahrenheit: " + f);
                } else if (Ch == 2) {
                    System.out.print("Enter Fahrenheit: ");
                    double f = sc.nextDouble();
                    double c = (f - 32) * 5 / 9;
                    System.out.println("Celsius: " + c);
                } else {
                    System.out.println("Invalid choice!");
                }
                break;

            case 2:
                System.out.println("1. USD to INR");
                System.out.println("2. INR to USD");
                int Choice = sc.nextInt();
                double rate = 83.0; // Example: 1 USD = 83 INR

                if (Choice == 1) {
                    System.out.print("Enter USD: ");
                    double usd = sc.nextDouble();
                    System.out.println("INR: " + (usd * rate));
                } else if (Choice == 2) {
                    System.out.print("Enter INR: ");
                    double inr = sc.nextDouble();
                    System.out.println("USD: " + (inr / rate));
                } else {
                    System.out.println("Invalid choice!");
                }
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
