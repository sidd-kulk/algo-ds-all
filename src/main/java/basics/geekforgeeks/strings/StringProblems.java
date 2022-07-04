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

    public static void main(String[] args) {
        printSorted("dcba");
    }
}
