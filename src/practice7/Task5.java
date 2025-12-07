package practice7;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Розмір квадратної матриці: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Введіть елементи:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] t = new int[n][n];

        // Транспонування
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[j][i] = matrix[i][j];
            }
        }

        System.out.println("Транспонована матриця:");
        for (int[] row : t) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }
}
