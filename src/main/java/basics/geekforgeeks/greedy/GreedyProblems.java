package basics.geekforgeeks.greedy;

import java.util.Arrays;
import java.util.Collections;

public class GreedyProblems {
    static int minimumNumberOfCoins(int[] coins, int amount) {
        if (coins == null) return 0;

        int minimumNumberOfCoins = 0;
        int remainingAmount = amount;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= remainingAmount) {
                int numberOfCoinsOfCurrentValue = remainingAmount / coins[i];
                minimumNumberOfCoins += numberOfCoinsOfCurrentValue;
                remainingAmount = remainingAmount - numberOfCoinsOfCurrentValue * coins[i];
            }
            if (remainingAmount == 0) break;
        }
        if(remainingAmount != 0) throw new RuntimeException("Could not satisfy the condition");

        return minimumNumberOfCoins;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 6, 2};
        Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        System.out.println(minimumNumberOfCoins(nums, 189));
    }

}
