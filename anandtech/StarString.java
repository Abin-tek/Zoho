import java.util.Scanner;

public class StarString {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i || j == n - i - 1 || j == n / 2)
                        System.out.print(str.charAt(i));
                    else if (i == n / 2)
                        System.out.print(str.charAt(j));
                    else
                        System.out.print(" ");
                    System.out.print("  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
