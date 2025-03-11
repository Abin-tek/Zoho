import java.time.LocalTime;
import java.util.Arrays;

public class DualPivotQuickSort {
    public static void dualPivotQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot positions
            int[] pivots = partition(arr, low, high);
            int p1 = pivots[0], p2 = pivots[1];

            // Recursively sort three partitions
            dualPivotQuickSort(arr, low, p1 - 1);
            dualPivotQuickSort(arr, p1 + 1, p2 - 1);
            dualPivotQuickSort(arr, p2 + 1, high);
        }
    }

    private static int[] partition(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) { // Ensure p1 < p2
            swap(arr, low, high);
        }

        int p1 = arr[low], p2 = arr[high];
        int i = low + 1, j = low + 1, k = high - 1;

        while (j <= k) {
            if (arr[j] < p1) { // Left partition
                swap(arr, i++, j++);
            } else if (arr[j] > p2) { // Right partition
                swap(arr, j, k--);
            } else { // Middle partition
                j++;
            }
        }
        swap(arr, low, --i); // Place p1 correctly
        swap(arr, high, ++k); // Place p2 correctly

        return new int[] { i, k }; // Return pivot positions
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 24, 8, 42, 75, 29, 77, 38, 57, 12, 95, 64, 32, 14, 89, 54, 68, 21, 37, 72, 11,
                50, 47, 99, 19, 85, 61, 90, 46, 36, 74, 28, 100, 41, 67, 31, 82, 56, 79, 23, 44,
                53, 71, 63, 10, 35, 92, 70, 26, 60, 13, 30, 87, 48, 20, 58, 80, 17, 40, 76, 52,
                98, 43, 22, 96, 15, 34, 59, 16, 97, 55, 62, 18, 33, 25, 86, 49, 27, 73, 65, 66,
                93, 94, 51, 81, 39, 88, 78, 91, 83, 84, 45, 69, 9, 5, 6, 3, 7, 2, 4, 1 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        System.out.println(LocalTime.now());
        dualPivotQuickSort(arr, 0, arr.length - 1);
        System.out.println(LocalTime.now());

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
