import java.util.Scanner;

class InvalidInputException extends Exception {
    private static final long serialVersionUID = 1L;

	InvalidInputException() {
        super("Invalid input");
    }
}

public class MaxAdjPairSum {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            if (n < 2) 
                throw new InvalidInputException();
            
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int max = arr[0] + arr[1];

            for (int i = 1; i < n - 1; i++)
                max = Math.max(max, arr[i] + arr[i + 1]);

            System.out.println(max);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
