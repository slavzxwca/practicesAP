package practice5;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть a: ");
        double a = sc.nextDouble();

        System.out.print("Введіть b: ");
        double b = sc.nextDouble();

        System.out.print("Введіть x: ");
        double x = sc.nextDouble();

        double fx;

        // Обчислення f(x) згідно з умовою
        if (x >= -1 && x < 6) {
            fx = Math.sin(x);
        } else if (x == 6) {
            fx = 3 * Math.pow(x, 2) + b * x - 3;
        } else if (x > 6) {
            fx = Math.log(b * x + a); // натуральний логарифм
        } else {
            System.out.println("x не входить у допустиму область [-1, +∞)");
            return;
        }

        // Виведення результату
        System.out.printf("f(x) = %.5f%n", fx);
    }
}


