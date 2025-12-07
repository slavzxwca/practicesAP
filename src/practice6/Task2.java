package practice6;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество углов: ");
        int n = sc.nextInt();

        int[] angles = new int[n];
        int sum = 0;

        System.out.println("Введите углы:");
        for (int i = 0; i < n; i++) {
            angles[i] = sc.nextInt();
            sum += angles[i];
        }

        int required = 180 * (n - 2);

        System.out.println("Сумма углов = " + sum + ", необходимая = " + required);

        if (sum == required)
            System.out.println("Многоугольник МОЖЕТ! существовать.");
        else
            System.out.println("Многоугольник НЕ может! существовать.");
    }
}