package basics.geekforgeeks.matrices;

import java.util.HashMap;

public class Matrices {

    public static void printSnakePattern(int[][] arr) {
        if (arr.length == 0) return;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= arr[i].length - 1; j++) {
                    System.out.print(arr[i][j]);
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
//        printSnakePattern(arr);

        int[] x = twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(x[0]);
        System.out.println(x[1]);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        var map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            var findNum = targetSum - array[i];
            if (map.containsKey(array[i])) {
                result[0] = findNum;
                result[1] = i;
                return result;
            }
            map.put(findNum, i);
            System.out.println(map);
        }
        return new int[0];
    }
}
