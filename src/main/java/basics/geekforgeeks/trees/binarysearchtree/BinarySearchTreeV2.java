package basics.geekforgeeks.trees.binarysearchtree;

import basics.Utils;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeV2 {

    static int findMinimum(BST tree) {
        if (tree == null) throw new RuntimeException("Null Root");
        return minimum(tree);
    }

    static int findMaximum(BST tree) {
        if (tree == null) throw new RuntimeException("Null Root");
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

    public static int closestDifferenceInBst(BST tree, int target) {
        if (tree == null) return Integer.MAX_VALUE;

        int leftNodeValueParam = closestDifferenceInBst(tree.left, target);
        int rightNodeValueParam = closestDifferenceInBst(tree.right, target);
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

    static List<Integer> ls = new ArrayList<>();
    static List<Integer> preorder(BST tree){
        if(tree == null) return ls;

        ls.add(tree.value);
        preorder(tree.left);
        preorder(tree.right);
        return ls;
    }

    static int findClosestVal(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        } else {
            if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
                closest = tree.value;
            }
            System.out.println("closest=" + closest + ", current=" + tree.value);
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

        System.out.println(preorder(bst));

    }

    static boolean isBalanced(BST tree) {
        return isBalanced(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBalanced(BST tree, int lower, int upper) {
        if(tree == null) return true;

        System.out.println("currNode="+tree);
        boolean isLeftBalanced = isBalanced(tree.left, lower, tree.value);
        boolean isRightBalanced = isBalanced(tree.right, tree.value, upper);

        System.out.println("isLeftBalanced="+isLeftBalanced+", isRightBalanced="+isRightBalanced);

        return (isLeftBalanced && isRightBalanced && tree.value >= lower && tree.value <= upper);
    }
}


class Program {
    static class BST1 {
        public int value;
        public BST1 left;
        public BST1 right;

        public BST1(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BST1{" +
                    "value=" + value +
                    '}';
        }

        public BST1 insert(int value) {
            BST1 node = this;
            if (value < node.value) {
                if (node.left == null) {
                    BST1 newNode = new BST1(value);
                    node.left = newNode;
                    return newNode;
                } else {
                    return node.left.insert(value);
                }
            } else if (value > node.value) {
                if (node.right == null) {
                    BST1 newNode = new BST1(value);
                    node.right = newNode;
                    return newNode;
                } else {
                    return node.right.insert(value);
                }
            } else {
                if (node.left == null) {
                    BST1 newNode = new BST1(value);
                    node.left = newNode;
                    return newNode;
                } else if (node.right == null) {
                    BST1 newNode = new BST1(value);
                    node.right = newNode;
                    return newNode;
                } else {
                    node.right.insert(value);
                }
            }

            return this;
        }

        public boolean contains(int value) {
            BST1 node = this;
            if (value < node.value) {
                if (node.left == null) return false;
                else return node.left.contains(value);
            } else if (value > node.value) {
                if (node.right == null) return false;
                else return node.right.contains(value);
            } else return true;
        }

        BST1 parentRef = this;

        public BST1 remove(int value) {
            BST1 node = this;
            if (value < node.value) {
                if (node.left == null) return null;
                else {
                    parentRef = node;
                    node.left.remove(value);
                }
            } else if (value > node.value) {
                if (node.right == null) return null;
                else {
                    parentRef = node;
                    node.right.remove(value);
                }
            } else {
                if (value > parentRef.value) {
                    parentRef.right = null;
                } else parentRef.left = null;
            }
            // Do not edit the return statement of this method.
            return this;
        }


    }

    public static void test() {

        BST1 bst = new BST1(10);

        bst.left = new BST1(5);
        bst.left.left = new BST1(2);
        bst.left.right = new BST1(6);
        bst.left.left.left = new BST1(-1);

        bst.right = new BST1(15);
        bst.right.left = new BST1(13);
        bst.right.left.right = new BST1(14);
        bst.right.right = new BST1(22);

        System.out.println(bst.contains(64));
        System.out.println(bst.insert(20));
    }

}
