// package anandtech;

import java.util.Arrays;

public class AssDes {

    public static void main(String[] args) {
        int[] arr = new int[] { 13, 2, 4, 15, 12, 10, 5 };
        int n = arr.length;

        // O(nLogn)
        int[] odd = new int[n / 2];
        int[] even = new int[n / 2 + (n % 2)];
        int oddIndex = 0, evenIndex = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                even[evenIndex++] = arr[i];
            else
                odd[oddIndex++] = arr[i];
        }

        Arrays.sort(even);
        Arrays.sort(odd);
        evenIndex = 0;
        oddIndex -= 1;

        for (int i = 0; i < n-1; i += 2) {
            arr[i] = even[evenIndex++];
            arr[i+1] = odd[oddIndex--];
        }

        if (n%2 == 1)
            arr[n-1] = even[evenIndex];
        

        // int start = 1, end = n - 1 - (n % 2);

        // // O(n)
        // while (start < end) {
        // tmp = arr[start];
        // arr[start] = arr[end];
        // arr[end] = tmp;
        // start += 2;
        // end -= 2;
        // }

        // // O(n^2)
        // int tmp = 0;
        // for (int i = 0; i < n - 2; i++) {
        // for (int j = 0; j < n - i - 2; j++) {
        // if (j % 2 == 0) {
        // if (arr[j] > arr[j + 2]) {
        // tmp = arr[j];
        // arr[j] = arr[j + 2];
        // arr[j + 2] = tmp;
        // }
        // } else {
        // if (arr[j] < arr[j + 2]) {
        // tmp = arr[j];
        // arr[j] = arr[j + 2];
        // arr[j + 2] = tmp;
        // }
        // }
        // }
        // }

        System.out.println(Arrays.toString(arr));
    }
}
