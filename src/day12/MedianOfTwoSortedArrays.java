package day12;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/26 18:25
 * Version: 1.0
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 思路：归并排序
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        int[] result = new int[len1 + len2];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                result[i + j] = nums1[i++];
            } else {
                result[i + j] = nums2[j++];
            }
        }
        while (i < len1)
            result[i + j] = nums1[i++];
        while (j < len2)
            result[i + j] = nums2[j++];

        int length = result.length;
        if (length % 2 == 0) {
            return (result[length / 2 - 1] + result[length / 2 + 1 - 1]) / 2.0;
        } else {
            return result[(length + 1) / 2 - 1];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 10};
        int[] b = {2, 3, 4, 6, 7, 8, 9, 12};
        findMedianSortedArrays(a, b);
    }

}
