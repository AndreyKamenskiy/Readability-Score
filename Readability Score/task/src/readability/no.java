package readability;

public class no {
    public static void main(String[] args) {
        String pattern = ".....\\\\";
        System.out.println("a1b2c.".matches(pattern)); // true
        System.out.println("Hello.".matches(pattern)); // true
        System.out.println("Hello\\".matches(pattern)); // false, ! does not  match \\.

    }
}
