package basics.geekforgeeks.matrices;

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
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        printSnakePattern(arr);
    }
}
