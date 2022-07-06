package basics.geekforgeeks.strings;

import basics.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringProblems {
    public static void main(String[] args) {
        System.out.println(RepeatingCharacters.LeftMostRepeatingCharacter.indexOfLeftMostRepeatingCharacter("abbcdd"));
    }
}

class RepeatingCharacters {

    static class LeftMostRepeatingCharacter {
        static int indexOfLeftMostRepeatingCharacter(String s) {
            if (s == null || s.length() <= 1) return -1;
            return usingAsciiAsCounter(s);
        }

        private static int usingBruteForceDoubleIteration(String s) {
            int index = -1;

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) return i;
                }
            }

            return index;
        }

        private static int usingMapCounter(String s) {
            Map<Character, Integer> counterMap = new LinkedHashMap<Character, Integer>();
            for (Character c : s.toCharArray()) {
                Integer count = counterMap.getOrDefault(c, 0);
                counterMap.put(c, ++count);
            }

            int res = -1;
            System.out.println(counterMap);
            for (Map.Entry entry : counterMap.entrySet()) {
                res++;
                if (entry.getValue() != null && (Integer) entry.getValue() > 1) return res;
            }
            return res;
        }

        private static int usingAsciiAsCounter(String s) {
            int[] counts = new int[256];

            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i)]++;
            }

            for (int i = 0; i < s.length(); i++) {
                if (counts[s.charAt(i)] > 1) return i;
            }
            return -1;
        }
    }
}


class PrintStrings {
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
}

class StringSubsequence {
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

}

class Anagram {
    static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        return isAnagramEfficientByCounting(s1, s2);
    }

    private static boolean isAnagramUsingFrequency(String s1, String s2) {
        Map<Character, Integer> s1Map = Utils.frequencyMap(s1);
        Map<Character, Integer> s2Map = Utils.frequencyMap(s2);

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
}