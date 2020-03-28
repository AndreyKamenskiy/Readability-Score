
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
    }
}
