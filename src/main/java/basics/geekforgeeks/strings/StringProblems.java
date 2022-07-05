package basics.geekforgeeks.strings;

import basics.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        if (s1 == null || s2 == null || s2.length() > s1.length()) return false;
        return checkStringSubsequenceRecursive(s1, s2, 0, 0);
    }

    private static boolean checkStringSubsequenceRecursive(String s1, String s2, int i, int j) {
        if (j == s2.length()) return true;
        if (i == s1.length()) return false;

        if (s1.charAt(i) == s2.charAt(j)) {
            return checkStringSubsequenceRecursive(s1, s2, ++i, ++j);
        } else {
            return checkStringSubsequenceRecursive(s1, s2, ++i, j);
        }
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        return isAnagramEfficientByCounting(s1, s2);
    }

    private static boolean isAnagramUsingFrequency(String s1, String s2) {
        Map<Character, Integer> s1Map = frequencyMap(s1);
        Map<Character, Integer> s2Map = frequencyMap(s2);

        for (Map.Entry e : s1Map.entrySet()) {
            if (e.getValue() != s2Map.get(e.getKey())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramBySorting(String s1, String s2) {
        return Utils.sortString(s1).equals(Utils.sortString(s2));
    }

    private static boolean isAnagramEfficientByCounting(String s1, String s2) {
        int[] counts = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
            counts[s2.charAt(i)]--;
        }
        return Arrays.stream(counts).allMatch(i -> i == 0);
    }

    private static Map frequencyMap(String s) {
        if (s == null) return null;

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("silent", "lidten"));
    }
}
