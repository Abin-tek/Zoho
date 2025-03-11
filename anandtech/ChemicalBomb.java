import java.util.Scanner;

class ChemicalBomb {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();
            int len = str.length();

            if (len % 2 == 0) {
                System.out.println("Venam Philips uh...");
                return;
            }

            int mid_center = len / 2, mid_corner = len / 2;

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i == j || i + j == len - 1) {
                        System.out.print(str.charAt(mid_center));
                    } else if (j == 0 || j == len - 1) {
                        System.out.print(str.charAt(mid_corner));
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                }
                if (i < len / 2) {
                    mid_center--;
                    mid_corner++;
                } else {
                    mid_center++;
                    mid_corner--;
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}