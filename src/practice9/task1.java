package practice9;
import java.util.Scanner;

public class task1 {
    public static String inputString() {
    Scanner scanner = new Scanner(System.in);
    String input;

    while (true) {
        System.out.println("Введіть строку (мінімум 2 слова, кожне від 3 символів):");
        input = scanner.nextLine().trim();

        String[] words = input.split("\\s+");

        if (words.length < 2) {
            System.out.println(" Потрібно мінімум 2 слова.");
            continue;
        }

        boolean valid = true;
        for (String word : words) {
            if (word.length() < 3) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            System.out.println(" Кожне слово має містити мінімум 3 символи.");
            continue;
        }

        break;
    }

    return input;
}

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseEachWord(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userString = inputString();

        System.out.println("\nОберіть дію:");
        System.out.println("2 — перевернути всю строку");
        System.out.println("3 — перевернути кожне слово окремо");

        int choice = scanner.nextInt();

        if (choice == 2) {
            System.out.println("Результат:");
            System.out.println(reverseString(userString));
        } else if (choice == 3) {
            System.out.println("Результат:");
            System.out.println(reverseEachWord(userString));
        } else {
            System.out.println(" Невірний вибір");
        }
    }
}

