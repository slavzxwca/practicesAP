package practice8;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть строку: ");
        String input = sc.nextLine();


        String cleaned = input.replace(" ", "").toLowerCase();


        String reversed = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversed)) {
            System.out.println("Це паліндром");
        } else {
            System.out.println("Це НЕ паліндром");
        }
    }
}
