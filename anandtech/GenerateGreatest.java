import java.util.Arrays;
import java.util.Scanner;

public class GenerateGreatest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = arr.length;

//		Integer concatenation : O(n.logn)
		Integer[] res = new Integer[n];
		for (int i = 0; i < n; i++)
			res[i] = arr[i];

		Arrays.sort(res, (a, b) -> {
			long ab = combine(a, b);
			long ba = combine(b, a);
			return Long.compare(ba, ab);
		});

		System.out.println(Arrays.toString(res));
		sc.close();
	}

	private static long combine(int a, int b) {
		int bDigits = (b == 0) ? 1 : (int) Math.log10(b) + 1;
		return (long) (a * Math.pow(10, bDigits) + b);
	}

}

/*
 * // Padding : O(n.logn) int[] res = new int[n]; int[][] mat = new int[n][2];
 * 
 * int max_dig = 0; for (int num : arr) { if (num == 0) continue; max_dig =
 * (int) Math.max(max_dig, Math.log10(num)); }
 * 
 * for (int i = 0; i < n; i++) { mat[i][0] = i; if (arr[i] == 0) continue; int
 * curr = arr[i]; int unit_digit = curr % 10; for (int j = (int)
 * Math.log10(curr); j < max_dig; j++) { curr = curr * 10 + unit_digit; }
 * mat[i][1] = curr; }
 * 
 * Arrays.sort(mat, (a, b) -> (b[1] - a[1]));
 * 
 * for (int i = 0; i < n; i++) { res[i] = arr[mat[i][0]]; }
 */

/*
 * // String concatenation : O(n.logn) String[] arrs = sc.nextLine().split(" ");
 * Arrays.sort(arrs, (a, b) -> (b + a).compareTo(a + b));
 */