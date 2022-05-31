package basics.geekforgeeks.trees.binarysearchtree;

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
        }
        else {
            root.left = insertRecursive(root.left, key);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);

        System.out.println(searchRecursive(root, 1));
        System.out.println(searchIterative(root, 1));
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
