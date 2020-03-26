
package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int sentences = text.split("[.!?]\\s*").length;
        int words = text.trim().split("\\s+").length;
        //System.out.printf("sentences=%d words=%d average=%.2f \n", sentences, words, ((float) words) / sentences );
        if (((float) words) / sentences > 10.0f) {
            System.out.print("HARD");
        } else {
            System.out.print("EASY");
        }
    }
}
