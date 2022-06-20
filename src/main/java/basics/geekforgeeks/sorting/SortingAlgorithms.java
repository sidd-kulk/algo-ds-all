package basics.geekforgeeks.sorting;

import java.util.Arrays;

public class SortingAlgorithms {

    static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 1) return nums;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean wasSwappingNeeded = false;
            for (int j = 0; j < nums.length - i - 1; j++) { // Optimization
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    wasSwappingNeeded = true;
                }
            }
            if (!wasSwappingNeeded) break;
        }
        return nums;
    }

    static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    static int[] mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] nums, int low, int high) {
        if (high > low) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            mergeFunction(nums, low, mid, high);
        }

        return nums;
    }

    static int[] mergeFunction(int[] nums, int low, int mid, int high) {
        if (nums == null) return null;
        if (low < 0 || low > mid || low > high || mid > high || high > nums.length - 1) {
            throw new RuntimeException("Incorrect input");
        }

        int[] nums1 = new int[mid - low + 1];
        int[] nums2 = new int[high - mid];

        for (int i = low; i < nums1.length; i++) {
            nums1[i] = nums[low + i];
        }

        for (int j = 0; j < nums2.length; j++) {
            nums2[j] = nums[mid + j + 1];
        }

        return mergeTwoSortedArrays(nums1, nums2);
    }

    static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) return nums2;
        if (nums2 == null) return nums1;

        int[] result = new int[nums1.length + nums2.length];

        int nums1Index = 0, nums2Index = 0, index = 0;
        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                result[index] = nums1[nums1Index];
                index++;
                nums1Index++;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                result[index] = nums2[nums2Index];
                index++;
                nums2Index++;
            }
        }

        while (nums1Index < nums1.length) {
            result[index] = nums1[nums1Index];
            index++;
            nums1Index++;
        }

        while (nums2Index < nums2.length) {
            result[index] = nums2[nums2Index];
            index++;
            nums2Index++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 4, 6, 8};

        int[] nums = new int[]{10, 15, 20, 40, 8, 11, 55};

        System.out.println(Arrays.toString(mergeSort(nums)));
    }
}
