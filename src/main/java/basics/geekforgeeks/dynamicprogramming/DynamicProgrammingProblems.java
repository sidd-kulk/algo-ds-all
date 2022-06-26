package basics.geekforgeeks.dynamicprogramming;

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

public class DynamicProgrammingProblems {

    public static void main(String[] args) {
        System.out.println("Memoized solution = " + LongestCommonSubsequence.longestCommonSubsequence("axyz", "baz"));
        System.out.println("Tabulation solution = " + LongestCommonSubsequence.memoizedLongestCommonSubsequence("axyz", "baz"));

    }

}
