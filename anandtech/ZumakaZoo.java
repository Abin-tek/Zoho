import java.util.Scanner;

public class ZumakaZoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] freq = new int[26];
        int less = 0, more = 0;
        char lessChar = ' ', moreChar = ' ';
        int n = s.length();

        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                if (less == 0 && freq[i] < i + 1) {
                    lessChar = (char) ('a' + i);
                    less++;
                } else if (more == 0 && freq[i] > i + 1) {
                    moreChar = (char) ('a' + i);
                    more++;
                }
            }
            if (less > 0 && more > 0)
                break;
        }

        if (less == 0 && more == 0) {
            System.out.println("Shortlisted");
        } else if (less > 0 && more == 0) {
            System.out.println("Less " + lessChar + " Shortlisted");
        } else if (less == 0 && more > 0) {
            System.out.println("More " + moreChar + " Shortlisted");
        } else {
            System.out.println("Rejected");
        }
        sc.close();
    }
}
