package day12;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/26 18:16
 * Version: 1.0
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

}
