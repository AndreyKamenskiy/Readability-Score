
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(Math.abs(i - j));
                s.append(" ");
            }
            s.replace(s.length() - 1, s.length(), "\n");
        }
        System.out.println(s);
    }
}
