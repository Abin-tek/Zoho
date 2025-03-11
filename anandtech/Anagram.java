// package anandtech;

import java.util.Scanner;

class Anagram {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String word1 = sc.next().toUpperCase();
            String word2 = sc.next().toUpperCase();

            if (word1.length() != word2.length()) {
                System.out.println(false);
                return;
            }

            int[] freq = new int[26];

            for (int i = 0; i < word1.length(); i++) {
                freq[word1.charAt(i) - 'A']++;
                freq[word2.charAt(i) - 'A']--;
            }

            for (int f : freq) {
                if (f != 0) {
                    System.out.println(false);
                    return;
                }
            }

            System.out.println(true);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}