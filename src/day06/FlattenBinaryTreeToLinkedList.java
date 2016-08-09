package day06;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/9 8:21
 * Version: 1.0
 */
public class FlattenBinaryTreeToLinkedList {

    //   Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void flatten(TreeNode root) {
        root = flattenTraverse(root);
    }

    private static TreeNode flattenTraverse(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode left = flattenTraverse(root.left);
        TreeNode right = flattenTraverse(root.right);
        root.left.right = right;
        root.right = root.left;
        return root;
    }

    public static void main(String[] args) {

    }

}
