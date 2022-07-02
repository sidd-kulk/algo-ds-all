package basics.geekforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DynamicProgrammingProblems {

    public static void main(String[] args) {
//        System.out.println("Memoized solution = " + LongestCommonSubsequence.longestCommonSubsequence("axyz", "baz"));
//        System.out.println("Tabulation solution = " + LongestCommonSubsequence.memoizedLongestCommonSubsequence("axyz", "baz"));
        System.out.println("*************");
//        System.out.println(Recursion.countBinaryStringsOfLength(8));
//        Recursion.subsets("abc");
        Recursion.subsets(Arrays.asList(1,2,3));
    }
}

class Recursion {
    static int max(int[] nums) {
        return max(nums, nums.length - 1);
    }

    private static int max(int[] nums, int i) {
        if (i == 0) return nums[0];
        return Math.max(nums[i], max(nums, i - 1));
    }

    static boolean isSorted(int[] nums) {
        return isSorted(nums, 0);
    }

    private static boolean isSorted(int[] nums, int i) {
        if (i == nums.length - 1) return true;

        if (nums[i + 1] >= nums[i] && isSorted(nums, i + 1)) {
            return true;
        }
        return false;
    }

    static void printDecreasingFrom(int n) {
        if (n == 0) return;

        printDecreasingFrom(n - 1);
        System.out.println(n);
    }

    static int power(int base, int power) {
        if (power == 1) return base;
        return base * power(base, power - 1);
    }

    static int tilingProblem(int n) { // 4 x n tiles
        if (n <= 3) {
            return 1;
        }

        int hori = tilingProblem(n - 4);
        int verti = tilingProblem(n - 1);
        return hori + verti;
    }

    static int countBinaryStringsOfLength(int n) {
        if (n == 1) return 2;
        return countBinaryStringsOfLength(n - 1) + countBinaryStringsOfLength(n - 1);
    }


    static void subsets(String s) {
        subsets(s, "", 0);
    }

    static void subsets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }

        subsets(s, curr, i + 1);
        subsets(s, curr + s.charAt(i), i + 1);
    }

    static void subsets(List<Integer> l) {
        subsets(l, new ArrayList<>(), 0);
    }

    static void subsets(List<Integer> l, List<Integer> currList, int i) {
        if (i == l.size()) {
            System.out.println(currList);
            return;
        }

        currList.add(l.get(i));
        subsets(l, currList, i + 1);

        if(i >= currList.size()) currList.remove(i);
        subsets(l, currList, i + 1);
    }
}

class Fibonacci {
    static int fibonacciMemoization(int n) {
        return fibonacciMemoization(n, null);
    }


    static int fiboniacciTabulation(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    static int fibonacciMemoization(int n, Integer[] memo) {
        if (n < 0) throw new RuntimeException("Negative input");
        if (n == 0 || n == 1) return n;

        if (memo == null) {
            memo = new Integer[n + 1];
        }

        if (memo != null && memo[n] != null) {
            return memo[n];
        }

        memo[n] = fibonacciMemoization(n - 1) + fibonacciMemoization(n - 2);
        return memo[n];
    }
}

class LongestCommonSubsequence {
    static int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    private static int lcs(char[] c1, char[] c2, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (c1[m - 1] == c2[n - 1]) {
            return 1 + lcs(c1, c2, m - 1, n - 1);
        } else {
            return Math.max(lcs(c1, c2, m - 1, n), lcs(c1, c2, m, n - 1));
        }
    }


    static int memoizedLongestCommonSubsequence(String s1, String s2) {
        return memoizedLcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), null);
    }

    private static int memoizedLcs(char[] c1, char[] c2, int m, int n, Integer[][] memo) {
        if (m == 0 || n == 0) return 0;

        if (memo == null) {
            memo = new Integer[m][n];
        }

        if (memo[m - 1][n - 1] != null) {
            return memo[m - 1][n - 1];
        }

        int x = 0;
        if (c1[m - 1] == c2[n - 1]) {
            x = 1 + memoizedLcs(c1, c2, m - 1, n - 1, memo);
        } else {
            x = Math.max(memoizedLcs(c1, c2, m - 1, n, memo), memoizedLcs(c1, c2, m, n - 1, memo));
        }

        memo[m - 1][n - 1] = x;
        return x;
    }
}

class Knapsack {
    static int unweighted(int[] weights, int capacity) {
        if (Arrays.stream(weights).sum() < capacity) return 0;
        return unweighted(weights, capacity, weights.length - 1);
    }

    private static int unweighted(int[] w, int c, int i) {
        if (c == 0 || i < 0) return 0;

        if (w[i] <= c) {
            int included = 1 + unweighted(w, c - w[i], i - 1);
            int notIncluded = unweighted(w, c, i - 1);
            return Math.max(included, notIncluded);
        } else {
            return unweighted(w, c, i - 1);
        }
    }

    static void generateSubsets(int[] nums) {


    }
}

class DPProblems {
    int minimumCuts(int[] coins, int n, Integer[] memo){

        if(memo[n] != null) {
            return memo[n];
        }

        if(n == 0) return 0;

        int minCuts = Integer.MAX_VALUE;

        // rec
        for(int i=0;i<coins.length;i++){
            int rem = n - coins[i];
            if(rem >= 0){
                int min = 1 + minimumCuts(coins, rem, memo);
                if(min > 0) minCuts = Math.min(minCuts, min);
            }
        }
        memo[n] =  minCuts == Integer.MAX_VALUE ? -1 : minCuts;
        return memo[n];

    }
}