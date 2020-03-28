
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    private static int[] getRow(String rowStr) {
        String[] s = rowStr.split(" ");
        int[] row = new int[s.length];
        for (int i = 0; i < row.length; i++) {
            row[i] = Integer.parseInt(s[i]);
        }
        return row;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> arr = new ArrayList<>(30);

        while (true) {
            String s = scanner.nextLine();
            if ("end".equals(s)) {
                break;
            }
            arr.add(getRow(s));
        }

        StringBuilder res = new StringBuilder();
        int y = arr.size();
        int x = arr.get(0).length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int sum = arr.get(i > 0 ? i - 1 : y - 1)[j] +
                        arr.get(i < y - 1 ? i + 1 : 0)[j] +
                        arr.get(i)[j > 0 ? j - 1 : x - 1] +
                        arr.get(i)[j < x - 1 ? j + 1 : 0];
                res.append(sum);
                res.append(" ");
            }
            res.replace(res.length() - 1, res.length(), "\n");
        }
        System.out.print(res);
    }
}
