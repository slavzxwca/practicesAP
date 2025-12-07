package practice7;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("К-сть рядків: ");
        int n = sc.nextInt();
        System.out.print("К-сть стовпців: ");
        int m = sc.nextInt();

        double[][] arr = new double[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Math.random() * 100;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 1 || j % 2 == 1) {
                    arr[i][j] = Math.sqrt(arr[i][j]);
                }
            }
        }

        System.out.println("\nМасив:");
        for (double[] row : arr) {
            for (double x : row) {
                System.out.printf("%.2f ", x);
            }
            System.out.println();
        }
    }
}
