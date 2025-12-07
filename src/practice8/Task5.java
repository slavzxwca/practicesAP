package practice8;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Стоп-слова, які треба замінити
        String[] badWords = {"долбаеб", "чорт", "лох", "пизда", "пидор", "сука", "блять", "ебать", "ебал"};

        System.out.print("Введіть текст: ");
        String input = sc.nextLine();

        for (String bad : badWords) {
            // Кожне стоп-слово міняємо на ***
            input = input.replaceAll("(?i)" + bad, "***");
        }

        System.out.println("Очищений текст:");
        System.out.println(input);
    }
}

