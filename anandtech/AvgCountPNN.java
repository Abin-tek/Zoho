import java.util.Arrays;
import java.util.Scanner;

public class AvgCountPNN {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int len = arr.length;
            int[] sign = new int[3];

            for (int num : arr) {
                if (num > 0)
                    sign[0]++;
                else if (num < 0)
                    sign[2]++;
                else
                    sign[1]++;
            }

            for (int count : sign)
                System.out.print(count / (float) len + " , ");

            System.out.print("\b\b ");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
