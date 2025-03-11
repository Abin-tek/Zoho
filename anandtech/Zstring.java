import java.util.Scanner;

public class Zstring {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();
            int len = str.length();

            if ((len - 1) % 3 != 0) {
                System.out.println("Venam Philips uh...");
                return;
            }

            int n = len / 3 + 1;
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || i == n - 1 || i + j == n - 1) {
                        System.out.print(str.charAt(index++) + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
