package practice7;

import java.util.*;

public class Task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Розмір матриці n: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Введіть матрицю:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Який мінор (рядок): ");
        int r = sc.nextInt();
        System.out.print("Який мінор (стовпець): ");
        int c = sc.nextInt();

        int[][] minor = new int[n - 1][n - 1];
        int mi = 0, mj;

        for (int i = 0; i < n; i++) {
            if (i == r) continue;
            mj = 0;
            for (int j = 0; j < n; j++) {
                if (j == c) continue;
                minor[mi][mj++] = matrix[i][j];
            }
            mi++;
        }

        System.out.println("Мінор:");
        for (int[] row : minor) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }
}
