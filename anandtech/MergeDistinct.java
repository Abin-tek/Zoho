import java.util.Arrays;
import java.util.Scanner;

public class MergeDistinct {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int i = 0, j = 0, k = 0;
            int n = arr1.length, m = arr2.length;
            int[] res = new int[n + m];

            while (i < n && j < m) {
                if (i > 0 && arr1[i] == arr1[i - 1]) {
                    i++;
                    continue;
                }
                if (j > 0 && arr2[j] == arr2[j - 1]) {
                    j++;
                    continue;
                }
                if (arr1[i] == arr2[j]) {
                    res[k++] = arr1[i++];
                    j++;
                } else if (arr1[i] < arr2[j])
                    res[k++] = arr1[i++];
                else
                    res[k++] = arr2[j++];
            }

            while (i < n)
                res[k++] = arr1[i++];
            while (j < m)
                res[k++] = arr2[j++];

            for (int x = 0; x < k; x++)
                System.out.print(res[x] + " ");
            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
