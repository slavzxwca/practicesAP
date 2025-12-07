package practice8;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть строку: ");
        String input = sc.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println("Перевернута строка: " + reversed);
    }
}
