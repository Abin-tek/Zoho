// package anandtech;

import java.util.Scanner;

public class NextBigger {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++)
                if (arr[i] > max)
                    max = arr[i];

            for (int i = 0; i < n; i++) {
                int next = max+1;
                for (int j = 0; j < n; j++) {
                    if (arr[i] == max)
                        break;
                    if (i != j && arr[j] > arr[i] && arr[j] < next)
                        next = arr[j];
                }

                System.out.print(arr[i] + " -> " + (arr[i] != max ? next : "") + ", ");
            }

            System.out.print("\b\b ");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
