import java.util.Scanner;

public class Main {
    static int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    static int prod(int n) {
        int res = 1;
        while (n > 0) {
            res *= n % 10;
            n /= 10;
        }
        return res;
    }

    static int sumDigits(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        if (num > 0) {
            int summary = sumDigits(num);
            int product = prod(num);
            System.out.printf("%d %d %d%n", summary, product, diff(summary, product));
        } else {
            System.out.println("Number is not natural");
        }
    }
}