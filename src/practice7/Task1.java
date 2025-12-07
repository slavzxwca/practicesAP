package practice7;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть висоту піраміди: ");
        int n = sc.nextInt();

        int[][] pyramid = new int[n][];


        for (int i = 0; i < n; i++) {
            pyramid[i] = new int[i + 1];
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = (int)(Math.random() * 50);
            }
        }

        System.out.println("\nПіраміда:");
        for (int[] row : pyramid) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        System.out.println("\nПіраміда у зворотному напрямку:");
        for (int i = n - 1; i >= 0; i--) {
            for (int j = pyramid[i].length - 1; j >= 0; j--) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
