package basics.geekforgeeks.dynamicprogramming;

public class DynamicProgrammingProblems {

    static int fibonacciMemoization(int n) {
        return fibonacciMemoization(n, null);
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

    static int fiboniacciTabulation(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println("Memoized solution = "+fibonacciMemoization(8));
        System.out.println("Tabulation solution = "+fiboniacciTabulation(8));
    }

}
