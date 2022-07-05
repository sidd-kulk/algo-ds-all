package basics.geekforgeeks.strings;

import org.jetbrains.annotations.NotNull;

public class StringProblems {
    static void printFrequency(String str) {
        int[] counts = getCounts(str);

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            String print = (char) (i + 'a') + "=" + counts[i];
            System.out.println(print);
        }
    }

    static void printSorted(String str) {
        int[] counts = getCounts(str);

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;

            for (int j = 0; j < counts[i]; j++) {
                System.out.print((char) (i + 'a'));
            }
        }
    }

    @NotNull
    private static int[] getCounts(String str) {
        int[] counts = new int[26];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int charInt = str.charAt(i);
            int indexCalculation = charInt - 'a';
            counts[indexCalculation]++;
        }
        return counts;
    }

    static boolean checkStringSubsequenceIterative(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j == s2.length()) return true;
        else return false;
    }

    static boolean checkStringSubsequenceRecursive(String s1, String s2) {
        return checkStringSubsequenceRecursive(s1, s2, 0, 0);
    }

    private static boolean checkStringSubsequenceRecursive(String s1, String s2, int i, int j) {
        if(j == s2.length()) return true;
        if(i == s1.length()) return false;

        if (s1.charAt(i) == s2.charAt(j)) {
            return checkStringSubsequenceRecursive(s1, s2, ++i, ++j);
        } else {
            return checkStringSubsequenceRecursive(s1, s2, ++i, j);
        }
    }

    public static void main(String[] args) {
        System.out.println(checkStringSubsequenceRecursive("geekforgeeks", "ge"));
    }
}
