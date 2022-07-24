package basics.leetcode.findLeavesOfBinaryTree;

import basics.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;



// LC 366 - https://leetcode.com/problems/find-leaves-of-binary-tree/
public class FindLeavesOfBinaryTree {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return null;
        findLeavesRecursive(root);
        return result;
    }

    private int findLeavesRecursive(TreeNode node){
        if(node == null) return -1;
        int l = findLeavesRecursive(node.left);
        int r = findLeavesRecursive(node.right);

        int maxHeight = 1+Math.max(l, r);
        if(result.size() <= maxHeight){
            result.add(new ArrayList<>());
        }

        result.get(maxHeight).add(node.val);
        return maxHeight;

    }
}
