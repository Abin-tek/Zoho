import java.util.Scanner;

public class ZXY {
    public static int digSum(int num) {
        int sum = 0;
        do {
            sum += num % 10;
        } while ((num /= 10) > 0);
        return sum;
    }

    public static int reverseNum(int num) {
        int rev = 0;
        do {
            rev = rev * 10 + (num % 10);
        } while ((num /= 10) > 0);
        return rev;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int z = start; z <= end; z++) {
                int x = digSum(z);
                int y = reverseNum(x);
                if (x * y == z)
                    System.out.print(z + " ");
            }
            
            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
