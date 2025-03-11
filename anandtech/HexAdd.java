import java.util.Scanner;

public class HexAdd {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s1 = sc.next().toUpperCase();
            String s2 = sc.next().toUpperCase();
            int l1 = s1.length() - 1;
            int l2 = s2.length() - 1;
            int q = 0, r = 0, sum = 0;
            String res = "";

            while (l1 >= 0 || l2 >= 0 || q != 0) {
                int n1 = (l1 >= 0) ? (s1.charAt(l1) > 64 ? 10 + s1.charAt(l1) - 'A' : s1.charAt(l1) - '0') : 0;
                int n2 = (l2 >= 0) ? (s2.charAt(l2) > 64 ? 10 + s2.charAt(l2) - 'A' : s2.charAt(l2) - '0') : 0;
                sum = n1 + n2 + q;
                q = sum / 16;
                r = sum % 16;
                char d = r > 9 ? (char) (55 + r) : (char) (48 + r);
                res = d + res;
                l1--;
                l2--;
            }
            System.out.println(res);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
