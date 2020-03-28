
package readability;

public class TextReadability {
    final int[] gradeAge = {5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 24};

    private String text;
    private int sentences;
    private int words;
    private int characters;
    private int syllables;
    private int polysyllables;

    private double ariScore;
    private double fkScore;
    private double smogScore;
    private double clScore;

    public TextReadability(String text) {
        this.text = text;
        analyse();
    }

    public void analyse() {
        sentences = text.split("[.!?]\\s*").length;

        String[] wordsArr = text.trim().split("\\s+");
        words = wordsArr.length;
        characters = text.replaceAll("\\s+","").length();

        for (String word :wordsArr) {
            int wordSyllables = TextReadability.syllables(word);
            syllables += wordSyllables;
            if (wordSyllables > 2) {
                polysyllables++;
            }
        }

        int letters = text.replaceAll("\\W","").length();

        ariScore = 4.71 * characters / words + 0.5 * words / sentences - 21.43;
        fkScore = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        smogScore = 1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291;

        double l = 100.0 * letters / words ;
        double s = 100.0 * sentences / words ;
        clScore = 0.0588 * l - 0.296 * s - 15.8;
    }

    public int getSentences() {
        return sentences;
    }

    public int getWords() {
        return words;
    }

    public int getSyllables() {
        return syllables;
    }

    public String getText() {
        return text;
    }

    public int getPolysyllables() {
        return polysyllables;
    }

    public int getCharacters() {
        return characters;
    }

    public double getARIScore() {
        return ariScore;
    }

    public double getFKScore() {
        return fkScore;
    }

    public double getSMOGScore() {
        return smogScore;
    }

    public double getCLScore() {
        return clScore;
    }

    public int getARIAge() {
        return getAge(ariScore);
    }

    public int getFKAge() {
        return getAge(fkScore);
    }

    public int getSMOGAge() {
        return getAge(smogScore);
    }

    public int getCLAge() {
        return getAge(clScore);
    }

    private int getAge(double score) {
        int intScore = (int) Math.ceil(score);
        if (intScore > 0 && intScore < 15) {
            return gradeAge[intScore];
        }
        return -1;
    }

    static int syllables(String word) {
        // "Hello, world!" sentence split to "Hello," + "world!" words;
        //delete non alphabetical symbols from word
        // replacing for " " is to "line-signal" word don't being converted to "linesignal" but to "line signal"
        // because linesignal = 4 syll's, but line signal = 3 syll's
        String lettersWord = word.toLowerCase().replaceAll("[^a-z]", " ").trim();

        int syllables = lettersWord.replaceAll("[aeiouy]+","a").replaceAll("[^aeiouy]","").length();
        if (lettersWord.endsWith("e")) {
            syllables--;
        }

        if (syllables == 0) {
            syllables = 1;
        }
        return syllables;
    }

}
