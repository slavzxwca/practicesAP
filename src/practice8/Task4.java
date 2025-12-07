package practice8;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть строку: ");
        String input = sc.nextLine();

        // Замінюємо "-" та "_" на пробіли, щоб легко розбити
        input = input.replace("-", " ").replace("_", " ");

        String[] words = input.split("\\s+");
        StringBuilder camel = new StringBuilder();

        camel.append(words[0].toLowerCase()); // перше слово завжди маленькими

        for (int i = 1; i < words.length; i++) {
            String w = words[i].toLowerCase();
            camel.append(Character.toUpperCase(w.charAt(0))) // перша буква велика
                    .append(w.substring(1));                    // інші маленькі
        }

        System.out.println("CamelCase: " + camel.toString());
    }
}
