import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int i = 0; i < n; i++) {
                pq.add(sc.nextInt());
            }
            int k = sc.nextInt();

            for (int i = 0; i < k; i++) {
                pq.poll();
            }

            System.out.println(pq.peek());
        }
    }
}