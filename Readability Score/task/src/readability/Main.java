
package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;

        //read text from file
        File file = new File(args[0]);
        StringBuilder text = new StringBuilder();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

        TextReadability tr = new TextReadability(text.toString());

        System.out.println("The text is:");
        System.out.println(tr.getText());
        System.out.println("\nWords: " + tr.getWords());
        System.out.println("Sentences: " + tr.getSentences());
        System.out.println("Syllables: " + tr.getSyllables());
        System.out.println("Polysyllables: " + tr.getPolysyllables());
        System.out.println("Characters: " + tr.getCharacters());

        scanner = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String choice = scanner.nextLine().trim();
        System.out.println();

        switch (choice) {
            case "ARI":
                System.out.printf("Automated Readability Index: %.2f (about %d year olds).\n"
                    , tr.getARIScore()
                    , tr.getARIAge());
                break;
            case "FK":
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).\n"
                        , tr.getFKScore()
                        , tr.getFKAge());
                break;
            case "SMOG":
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).\n"
                        , tr.getSMOGScore()
                        , tr.getSMOGAge());
                break;
            case "CL":
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds).\n"
                        , tr.getCLScore()
                        , tr.getCLAge());
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f (about %d year olds).\n"
                        , tr.getARIScore()
                        , tr.getARIAge());
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).\n"
                        , tr.getFKScore()
                        , tr.getFKAge());
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).\n"
                        , tr.getSMOGScore()
                        , tr.getSMOGAge());
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds).\n"
                        , tr.getCLScore()
                        , tr.getCLAge());
                double averageAge = (tr.getARIScore() + tr.getFKAge() +
                            tr.getSMOGAge() + tr.getCLAge()) / 4.0;
                System.out.printf("\nThis text should be understood in average by %.2f year olds.\n"
                        , averageAge);
                break;
            default:
                System.out.println("Unknown choice");
        }

/*        String age = null;
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
        System.out.printf("This text should be understood by %s year olds.", age); */
    }
}
