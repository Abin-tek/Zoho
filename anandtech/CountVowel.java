import java.util.Scanner;

class CountVowel {
    public static boolean isVowel(char c) {
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String word = sc.next().toUpperCase();
            int count = 0;
            for (char c : word.toCharArray())
                if (isVowel(c))
                    count++;

            System.out.println(count == 0 ? "No vowel" : count);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}