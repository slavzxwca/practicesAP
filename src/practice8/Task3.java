package practice8;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть речення: ");
        String input = sc.nextLine();


        String[] words = input.split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for (String w : words) {
            if (w.length() < shortest.length()) shortest = w;
            if (w.length() > longest.length()) longest = w;
        }

        System.out.println("Найкоротше слово: " + shortest + " (" + shortest.length() + ")");
        System.out.println("Найдовше слово: " + longest + " (" + longest.length() + ")");
    }
}
