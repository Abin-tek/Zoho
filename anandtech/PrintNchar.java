import java.util.Scanner;

public class PrintNchar {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();
            int i = 0;
            while (i < str.length()) {
                char c = str.charAt(i++);
                int num = 0;
                int n;
                do {
                    n = str.charAt(i++) - '0';
                    num = num * 10 + n;
                } while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0');

                for (int j = 0; j < num; j++)
                    System.out.print(c);
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
