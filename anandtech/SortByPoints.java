import java.util.Arrays;
import java.util.Scanner;

class SortByPoints {
    public static boolean isPerfectSquare(int num) {
        for (int i = 1; i * i <= num; i++)
            if (i * i == num)
                return true;

        return false;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            int[][] points = new int[n][2];

            for (int i = 0; i < n; i++) {
                int curr = arr[i];
                points[i][0] = curr;
                if (isPerfectSquare(curr))
                    points[i][1] += 5;
                if (curr % 4 == 0 && curr % 6 == 0)
                    points[i][1] += 4;
                if (curr % 2 == 0)
                    points[i][1] += 3;
            }

            Arrays.sort(points, (a, b) -> (b[1] - a[1]));

            for (int[] res : points)
                System.out.print(res[0] + " ");

            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}