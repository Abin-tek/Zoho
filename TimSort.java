import java.util.Arrays;

public class TimSort {
    private static final int RUN = 32;

    // Using Insertion Sort for small subarrays (runs)
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merging two sorted subarrays using Merge Sort approach
    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);

        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < len1) arr[k++] = left[i++];
        while (j < len2) arr[k++] = right[j++];
    }

    // Main TimSort function
    public static void timSort(int[] arr, int n) {
        // Step 1: Sort small chunks (runs) using Insertion Sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        // Step 2: Merge runs using Merge Sort approach
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    // Driver code to test TimSort
    public static void main(String[] args) {
        int[] arr = { 24, 8, 42, 75, 29, 77, 38, 57, 12, 95, 64, 32, 14, 89, 54, 68, 21, 37, 72, 11,
                50, 47, 99, 19, 85, 61, 90, 46, 36, 74, 28, 100, 41, 67, 31, 82, 56, 79, 23, 44,
                53, 71, 63, 10, 35, 92, 70, 26, 60, 13, 30, 87, 48, 20, 58, 80, 17, 40, 76, 52,
                98, 43, 22, 96, 15, 34, 59, 16, 97, 55, 62, 18, 33, 25, 86, 49, 27, 73, 65, 66,
                93, 94, 51, 81, 39, 88, 78, 91, 83, 84, 45, 69, 9, 5, 6, 3, 7, 2, 4, 1 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        // System.out.println(LocalTime.now());
        timSort(arr, arr.length);
        // System.out.println(LocalTime.now());

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
