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
//        root = flattenTraverse(root);
        flatten(root,null);
    }

//    static TreeNode mPrev = null;
//
//    private static TreeNode flattenTraverse(TreeNode root) {
//        if (root == null ) {
//            return root;
//        }
//        TreeNode right = flattenTraverse(root.right);
//        TreeNode left = flattenTraverse(root.left);
//        right = mPrev;
//        left = null;
//        mPrev = root;
//        return root;
//    }

    private static TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root==null) return pre;
        pre=flatten(root.right,pre);
        pre=flatten(root.left,pre);
        root.right=pre;
        root.left=null;
        pre=root;
        return pre;
    }

    public static void main(String[] args) {

    }

}
