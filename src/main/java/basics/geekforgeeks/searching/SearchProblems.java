package basics.geekforgeeks.searching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




import java.util.*;










public class SearchProblems {

    public static void main(String[] args) {
//        var nums = new int[]{1, 2, 3, 3, 3, 4, 4, 5, 6, 6, 6, 7};
//        for (int i = 1; i < nums.length; i++) {
//            System.out.println("first index of " + i + "=" + indexOfFirstOccurrenceInSortedArray(nums, i));
//        }

        var nums = new int[] {8, 5, 2, 9, 7, 6, 3};
        System.out.println(quickselect(nums, 2));
    }
    public static int quickselect(int[] array, int k) {
        // Quick Select
        if(array == null) return -1;
        if(array.length == 1) {
            return array[0];
        }
        return quickSelect(array, k, 0, array.length-1);
    }

    private static int quickSelect(int[] array, int k, int low, int high){
        if(low <= high) {
            int pivotIndex = partition(array, low, high);
            if(k - 1 == pivotIndex) {
                return array[pivotIndex];
            } else if(k -1 < pivotIndex){
                return quickSelect(array, k, low, pivotIndex-1);
            } else {
                return quickSelect(array, k, pivotIndex+1, high);
            }
        }
        return -1;
    }

    private static int partition(int[] array, int low, int high) {
        int i=low, j=high;
        int pivot = array[i];
        while(i < j){
            while(i < high && array[i] <= pivot){
                i++;
            }

            while(j> low && array[j] > pivot){
                j--;
            }
            System.out.println("i="+i + ", j="+j);
            if(i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }


        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;


        return j;
    }










    static int binarySearchIterative(int[] nums, int searchKey) {
        // [1,2,3,4,5,6]
        if (nums == null) return -1;
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            int value = nums[mid];
            if (value > searchKey) {
                j = mid - 1;
            } else if (value < searchKey) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int binarySearchRecursive(int[] nums, int searchKey) {
        if (nums == null) return -1;
        return binarySearchRecursive(nums, searchKey, 0, nums.length - 1);
    }

    private static int binarySearchRecursive(int[] nums, int searchKey, int i, int j) {
        // [1,2,3,4,5,6]
        if (i > j) return -1;
        int mid = (i + j) / 2;
        int value = nums[mid];
        if (value > searchKey) {
            return binarySearchRecursive(nums, searchKey, i, mid - 1);
        } else if (value < searchKey) {
            return binarySearchRecursive(nums, searchKey, mid + 1, j);
        } else {
            return mid;
        }
    }

    static int indexOfFirstOccurrenceInSortedArray(int[] nums, int searchKey) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int value = nums[mid];
            if (value > searchKey) {
                j = mid - 1;
            } else if (value < searchKey) {
                i = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != searchKey) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    static int shiftedBinarySearch(int[] nums, int searchKey) {
        if (nums == null) return -1;
        if (nums.length == 1) {
            if (nums[0] == searchKey) return 0;
            else return -1;
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i+j)/2;
            int value = nums[mid];
            if(searchKey == value) return mid;
            else if(nums[i] < value){
                if(searchKey >= nums[i] && searchKey < value){
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if(searchKey > value && searchKey <= nums[j]){
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }



    static void testBinarySearch() {
        var nums = new int[]{10, 20, 30, 40, 50, 60};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(binarySearchIterative(nums, i * 10));
            System.out.println(binarySearchRecursive(nums, i * 10));
        }
        System.out.println(binarySearchRecursive(nums, 555));
        System.out.println(binarySearchIterative(nums, 555));
    }
}
