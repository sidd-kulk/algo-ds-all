package basics.geekforgeeks.trees.binarysearchtree;

import basics.Utils;

public class BinarySearchTreeV2 {

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

        @Override
        public String toString() {
            return "BST{" +
                    "value=" + value +
                    '}';
        }
    }

    public static int closestInBinaryTree(BST tree, int target) {
        if (tree == null) return Integer.MAX_VALUE;

        int leftNodeValueParam = closestInBinaryTree(tree.left, target);
        int rightNodeValueParam = closestInBinaryTree(tree.right, target);
        int diff = Math.abs(tree.value - target);
        return Utils.min(diff, leftNodeValueParam, rightNodeValueParam);
    }

    public static int findClosestValueInBst(BST tree, int target) {
        if (tree == null) return Integer.MAX_VALUE;

        int leftNodeValueParam = findClosestValueInBst(tree.left, target);
        int rightNodeValueParam = findClosestValueInBst(tree.right, target);
        int currNode = tree.value;
        int diff = Math.abs(currNode - target);

        if (leftNodeValueParam != Integer.MAX_VALUE && diff > Math.abs(target - leftNodeValueParam)) {
            currNode = leftNodeValueParam;
        }
        if (rightNodeValueParam != Integer.MAX_VALUE && Math.abs(currNode - target) > Math.abs(target - rightNodeValueParam)) {
            currNode = rightNodeValueParam;
        }
        return currNode;
    }

    static int findClosestVal(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        } else {
            if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
                closest = tree.value;
            }
            System.out.println("closest="+closest+", current="+tree.value);
            if (target < tree.value) {
                return findClosestVal(tree.left, target, closest);
            } else {
                return findClosestVal(tree.right, target, closest);
            }
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);

        bst.left = new BST(5);
        bst.left.left = new BST(2);
        bst.left.right = new BST(6);
        bst.left.left.left = new BST(-1);

        bst.right = new BST(15);
        bst.right.left = new BST(13);
        bst.right.left.right = new BST(14);
        bst.right.right = new BST(22);

//        int nodeValue = closestInBinaryTree(bst, -99);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$");
        int node = findClosestVal(bst, 15, Integer.MAX_VALUE);
        System.out.println(node);
    }
}
