package day05;

/**
 * 仅支持方阵！！！
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/7 20:53
 * Version: 1.0
 */
public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int i = 0;
        for (; i < length && matrix[i][i] < target; i++) ;
        if (i >= length || i < 0) return false;
        if (matrix[i][i] == target) return true;

        int j = i;
        while (i >= 0) {
            if (matrix[i][j] == target || matrix[j][i] == target) return true;
            i--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean b = searchMatrix(array, 0);
        System.out.println(b);
    }
}
