import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroToFront {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int z = arr.length - 1;

            for (int i = z; i >= 0; i--)
                if (arr[i] != 0)
                    arr[z--] = arr[i];

            while (z >= 0)
                arr[z--] = 0;

            System.out.println(Arrays.toString(arr));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}