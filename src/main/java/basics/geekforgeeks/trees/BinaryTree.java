package basics.geekforgeeks.trees;

import static java.lang.System.out;

public class BinaryTree<T> {
    private final JTreeNode<T> head;

    public BinaryTree(JTreeNode<T> head) {
        this.head = head;
    }

    public int maxDepth() {
        return depth(head);
    }

    private int depth(JTreeNode<T> node) {
        if (node == null) return 0;
        var leftDepth = depth(node.getLeft());
        var rightDepth = depth(node.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        JTreeNode<Integer> root = new JTreeNode<>(1);
        root.setLeft(new JTreeNode<>(2));
        root.setRight(new JTreeNode<>(3));
        root.getLeft().setLeft(new JTreeNode<>(4));
        out.println(root);
        out.println(new BinaryTree<Integer>(root).maxDepth());
    }
}

class JTreeNode<T> {
    private JTreeNode<T> left;
    private JTreeNode<T> right;
    private final T value;

    public JTreeNode(T value) {
        this.value = value;
    }

    public JTreeNode<T> getLeft() {
        return left;
    }

    public JTreeNode<T> getRight() {
        return right;
    }

    public void setLeft(JTreeNode left) {
        this.left = left;
    }

    public void setRight(JTreeNode right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}