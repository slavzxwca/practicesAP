import java.util.Scanner;

public class practice4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Оберіть завдання:");
        System.out.println("1 — Обчислення f(x)");
        System.out.println("2 — Реверс цілого числа");
        System.out.print("Ваш вибір: ");
        int choice = in.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Введіть a: ");
                double a = in.nextDouble();

                System.out.print("Введіть b: ");
                double b = in.nextDouble();

                System.out.print("Введіть x: ");
                double x = in.nextDouble();

                double f;

                if (x >= 1 && x < 3) {
                    f = 9 / (a * x);
                } else if (x == 3) {
                    f = a * x * x + x + b;
                } else {
                    System.out.println("x поза діапазоном [1,3]");
                    return;
                }

                System.out.println("f(x) = " + f);
            }

            case 2 -> {
                System.out.print("Введіть ціле число: ");
                int num = in.nextInt();

                int reversed = 0;
                int temp = num;
                while (temp != 0) {
                    reversed = reversed * 10 + temp % 10;
                    temp /= 10;
                }
                System.out.printf("Реверс: %010d%n", reversed);
            }

            default -> System.out.println("Невірний вибір!");
        }
    }
}