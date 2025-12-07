package practice6;

public class Task4 {
    public static void main(String[] args) {

        System.out.println("Таблица синусов 0–90:");

        int count = 0;

        for (int i = 0; i <= 90; i++) {
            double rad = Math.toRadians(i);
            double sinValue = Math.sin(rad);

            System.out.printf("%.5f\t", sinValue);
            count++;

            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }
}