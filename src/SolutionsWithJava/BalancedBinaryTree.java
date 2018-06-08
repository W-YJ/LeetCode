package SolutionsWithJava;

/*
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * runtime beats: 85.84%
 * */


public class BalancedBinaryTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
