package basics.geekforgeeks.trees.binarysearchtree;

import com.sun.source.util.Trees;

import java.util.TreeSet;

public class BinarySearchTrees {
    public static boolean searchRecursive(Node root, int key) {
        if (root == null) return false;

        if (root.value == key) return true;
        if (root.value < key) return searchRecursive(root.right, key);
        else return searchRecursive(root.left, key);
    }

    public static boolean searchIterative(Node root, int key) {
        while (root != null) {
            if (root.value == key) return true;

            if (root.value < key) root = root.right;
            else root = root.left;
        }
        return false;
    }

    public static Node insertRecursive(Node root, int key) {
        if (root == null) return new Node(key);

        if (root.value < key) {
            root.right = insertRecursive(root.right, key);
        } else {
            root.left = insertRecursive(root.left, key);
        }
        return root;
    }

    static Node floor(Node root, int key) {
        Node result = root;
        if (root.value > key) return null;
        while (root != null) {
            if (root.value == key) return root;
            else if (root.value > key) root = root.left;
            else {
                result = root;
                root = root.right;
            }
        }
        return result;
    }

    static Node ceiling(Node root, int key) {
        Node result = root;
        if (root.value < key) return null;
        while (root != null) {
            if (root.value == key) return root;
            else if (root.value > key) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);

        BinarySearchTrees.leftSideCeilingOfArray(new int[] {2, 8, 30,15,25,12});
    }

    static void leftSideCeilingOfArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        System.out.print("-1, ");
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            final Integer ceiling = bst.ceiling(nums[i]);
            if(ceiling != null){
                System.out.print(ceiling+", ");
            } else {
                System.out.print("-1, ");
            }
            bst.add(nums[i]);
        }
    }
}

class Node {
    Node(int value) {
        this.value = value;
    }

    Node left;
    Node right;
    int value;
}
