package practice6;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Массив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(50);
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nВведите значение для поиска: ");
        int findVal = sc.nextInt();

        System.out.print("Введите значение для замены: ");
        int replaceVal = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == findVal)
                arr[i] = replaceVal;
        }

        System.out.print("Новый массив: ");
        for (int x : arr)
            System.out.print(x + " ");
    }
}

