package practice6;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Массив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(100);
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n1 — проверить на возрастание\n2 — на убывание\nВаш выбор: ");
        int mode = sc.nextInt();

        boolean ok = true;

        if (mode == 1) { // Возрастание
            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) ok = false;
            }
            System.out.println(ok ? "Массив возрастает." : "Массив НЕ возрастает.");
        } else { // Убывание
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i - 1]) ok = false;
            }
            System.out.println(ok ? "Массив убывает." : "Массив НЕ убывает.");
        }
    }
}
