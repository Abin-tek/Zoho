// package anandtech;

import java.util.Scanner;

class ValuesInRange {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int h = sc.nextInt();
            
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int num : arr) {
                if (l < num && num < h) {
                    System.out.println(num);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}