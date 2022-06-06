package basics.geekforgeeks.searching;

public class SearchProblems {
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
            System.out.println("mid="+mid+", value="+value);
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

    public static void main(String[] args) {
        var nums = new int[]{1,2,3,3,3,4,4,5,6,6,6,7};
        for (int i = 1; i < 2; i++) {
            System.out.println("first index of "+i +"="+indexOfFirstOccurrenceInSortedArray(nums, i));
        }
    }

    static void testBinarySearch(){
        var nums = new int[]{10, 20, 30, 40, 50, 60};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(binarySearchIterative(nums, i * 10));
            System.out.println(binarySearchRecursive(nums, i * 10));
        }
        System.out.println(binarySearchRecursive(nums, 555));
        System.out.println(binarySearchIterative(nums, 555));
    }
}
