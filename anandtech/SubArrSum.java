// package anandtech;

import java.util.Scanner;

public class SubArrSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) 
                arr[i] = sc.nextInt();

            int gap = sc.nextInt();
            if (n < gap)
                throw new Exception("Invalid input");
            
            int[] res = new int[gap];

            for (int i = 0; i < gap; i++)
                for (int j = i; j < n; j += gap)
                    res[i] += arr[j];

            for (int num : res) 
                System.out.println(num);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
