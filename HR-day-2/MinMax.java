import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int min1 = sc.nextInt();
            int min2 = sc.nextInt();
            int max1 = sc.nextInt();
            int max2 = sc.nextInt();

            int min1_ind = -1, min2_ind = -1;
            int max1_first = -1, max1_last = -1;
            int max2_first = -1, max2_last = -1;
            int min_dist = Integer.MAX_VALUE, max_dist = -1;

            for (int i = 0; i < n; i++) {
                int val = arr[i];

                // Update min1 and min2 indices
                if (val == min1) {
                    if (min2_ind != -1)
                        min_dist = Math.min(min_dist, i - min2_ind);
                    min1_ind = i;
                }
                if (val == min2) {
                    if (min1_ind != -1)
                        min_dist = Math.min(min_dist, i - min1_ind);
                    min2_ind = i;
                }

                // Track first and last occurrence of max1 and max2
                if (val == max1) {
                    if (max1_first == -1)
                        max1_first = i;
                    max1_last = i;
                }
                if (val == max2) {
                    if (max2_first == -1)
                        max2_first = i;
                    max2_last = i;
                }
            }

            // Handle cases where min1 or min2 is missing
            if (min1_ind == -1 || min2_ind == -1)
                min_dist = -1;

            // Ensure max1 appears at least twice (for max1 == max2), before computing max_dist
            if (max1_first != -1 && max2_first != -1 && max1_first != max1_last) {
                max_dist = Math.max(Math.abs(max1_first - max2_last), Math.abs(max2_first - max1_last));
            }

            System.out.println(min_dist + " " + max_dist);
        }
        sc.close();
    }
}
