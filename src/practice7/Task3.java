package practice7;

import java.util.*;

public class Task3 {

    public static int determinant(int[][] matrix, int n) {
        int det = 0;

        if (n == 1)
            return matrix[0][0];

        int[][] temp = new int[n][n];
        int sign = 1;

        for (int f = 0; f < n; f++) {
            getCofactor(matrix, temp, 0, f, n);
            det += sign * matrix[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return det;
    }

    public static void getCofactor(int[][] mat, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[5][5];

        System.out.println("Введіть 25 чисел для матриці 5x5:");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int det = determinant(matrix, 5);
        System.out.println("Визначник матриці = " + det);
    }
}
