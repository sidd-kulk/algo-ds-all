package basics.geekforgeeks;

public class ArrayProblems {

    public static void leaderOfArray(int[] arr) {
        if (arr == null) return;

        int currentRightMax = arr[arr.length - 1];
        System.out.println(currentRightMax);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > currentRightMax) {
                currentRightMax = arr[i];
                System.out.println(arr[i]);
            }
        }
    }

    public static int maxDifferenceFromRightToLeft(int[] arr) {
        if (arr == null) return 0;
        if (arr.length == 1) return 0;

        int maxDifference = arr[1] - arr[0];
        int currMinValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxDifference = Math.max(maxDifference, arr[i] - currMinValue);
            currMinValue = Math.min(currMinValue, arr[i]);
        }
        return maxDifference;
    }


    public static int stockBuyProblem(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    public static int trappedRainWater(int[] arr) {

    }

    public static void main(String[] args) {
        System.out.println(ArrayProblems.stockBuyProblem(new int[]{17, 10, 4, 3, 8, 5, 7}));
    }

}
