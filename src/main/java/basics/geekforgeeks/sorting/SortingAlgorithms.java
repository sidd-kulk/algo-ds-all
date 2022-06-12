package basics.geekforgeeks.sorting;

import java.util.Arrays;

public class SortingAlgorithms {

    static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 1) return nums;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) { // Optimization
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 6, 4, 7, -1};
        bubbleSort(nums);
    }
}
