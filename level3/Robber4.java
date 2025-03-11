import java.util.Arrays;

public class Robber4 {
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();

        while (low < high) {
            int mid = (low + high) >>> 1; // Safe midpoint calculation
            if (canRob(nums, k, mid))
                high = mid; // Try to minimize the max capability
            else
                low = mid + 1;
        }
        return low;
    }

    private boolean canRob(int[] nums, int k, int maxCapability) {
        int count = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] <= maxCapability) {
                count++; // Rob this house
                i++; // Skip next house (no adjacent robbing)
            }
            i++; // Move to next house
        }
        return count >= k;
    }

    public static void main(String[] args) {
        System.out.println(new Robber4().minCapability(new int[] { 6, 7, 9, 3, 1 }, 2));
    }
}
