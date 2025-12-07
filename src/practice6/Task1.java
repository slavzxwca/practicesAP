package practice6;

import java.util.*;

public class Task1 {
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

        int even = 0, odd = 0;

        for (int x : arr) {
            if (x % 2 == 0) even++;
            else odd++;
        }

        System.out.println("\nЧётных: " + even);
        System.out.println("Нечётных: " + odd);
    }
}