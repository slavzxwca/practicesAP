package practice8;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть строку: ");
        String input = sc.nextLine();

        // Прибираємо пробіли та переводимо до нижнього регістру
        String cleaned = input.replace(" ", "").toLowerCase();

        // Перевертаємо строку
        String reversed = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversed)) {
            System.out.println("Це паліндром");
        } else {
            System.out.println("Це НЕ паліндром");
        }
    }
}
