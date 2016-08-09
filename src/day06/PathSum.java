package day06;

/**
 * https://leetcode.com/problems/path-sum/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/9 14:08
 * Version: 1.0
 */
public class PathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int s = sum - root.val;
        if (root.left == null && root.right == null) return s == 0;
        if (hasPathSum(root.left, s)) return true;
        if (hasPathSum(root.right, s)) return true;

        return false;
    }

    public static void main(String[] args) {

    }

}
