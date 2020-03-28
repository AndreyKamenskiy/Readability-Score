
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            s.append(scanner.nextLine());
        }
        for (int i = 0; i < 11; i++) {
            if (i % 4 == 3) {
                i++;
            }
            if (s.substring(i, i + 2).equals(s.substring(i + 4, i + 6))
                    && s.charAt(i) == s.charAt(i + 1)) // for case {WB},{WB}
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
