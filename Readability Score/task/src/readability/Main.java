
package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        File file = new File(args[0]);
        StringBuilder text = new StringBuilder();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
            System.exit(1);
        }
        String string = text.toString();
        int sentences = string.split("[.!?]\\s*").length;
        int words = string.trim().split("\\s+").length;

        int characters = string.replaceAll("\\s+","").length();
        double score = 4.71 * characters / words + 0.5 * words / sentences - 21.43;

        System.out.println("The text is:");
        System.out.println(string);
        System.out.println("\nWords: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.printf("The score is: %.2f\n", score);
        String age = null;

        switch ((int) Math.ceil(score)) {
            case 1:
                age = "5-6";
                break;
            case 2:
                age = "6-7";
                break;
            case 3:
                age = "7-9";
                break;
            case 4:
                age = "9-10";
                break;
            case 5:
                age = "10-11";
                break;
            case 6:
                age = "11-12";
                break;
            case 7:
                age = "12-13";
                break;
            case 8:
                age = "13-14";
                break;
            case 9:
                age = "14-15";
                break;
            case 10:
                age = "15-16";
                break;
            case 11:
                age = "16-17";
                break;
            case 12:
                age = "17-18";
                break;
            case 13:
                age = "18-24";
                break;
            case 14:
                age = "24+";
                break;
            default:
                age = "unknown_" + score;
        }
        System.out.printf("This text should be understood by %s year olds.", age);
    }
}
