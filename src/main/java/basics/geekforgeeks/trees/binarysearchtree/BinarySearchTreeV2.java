package basics.geekforgeeks.trees.binarysearchtree;

import basics.Utils;

public class BinarySearchTreeV2 {
    static int nearestNodeValue = 0;

    public static int findClosestValueInBst(BST tree, int target) {
        return -1;
    }

    static int findMinimum(BST tree) {
        if(tree == null) throw new RuntimeException("Null Root");
        return minimum(tree);
    }

    static int findMaximum(BST tree) {
        if(tree == null) throw new RuntimeException("Null Root");
        return maximum(tree);
    }

    private static int minimum(BST tree) {
        if (tree == null) return Integer.MAX_VALUE;

        int leftMin = minimum(tree.left);
        int rightMin = minimum(tree.right);
        return Utils.min(leftMin, rightMin, tree.value);
    }

    private static int maximum(BST tree) {
        if (tree == null) return Integer.MIN_VALUE;

        int leftMax = maximum(tree.left);
        int rightMax = maximum(tree.right);
        return Utils.max(leftMax, rightMax, tree.value);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);

        bst.left = new BST(5);
        bst.left.left = new BST(2);
        bst.left.right = new BST(5);
        bst.left.left.left = new BST(-1);

        bst.right = new BST(15);
        bst.right.left = new BST(13);
        bst.right.left.right = new BST(14);
        bst.right.right = new BST(22);
        bst.right.right.left = new BST(0);

        System.out.println(findMinimum(bst));
        System.out.println(findMaximum(bst));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$");
    }
}
