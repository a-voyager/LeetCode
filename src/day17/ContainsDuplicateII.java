package day17;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/9/1 21:57
 * Version: 1.0
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[] numbers = nums.clone();
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = 0; j < numbers.length; j++) {
                    // nums[j]  numbers[i]
                    if (nums[j] == numbers[i]) {
                        arrayList.add(j);
                    }
                }

                for (int j = 1; j < arrayList.size(); j++) {
                    if (arrayList.get(j) - arrayList.get(j - 1) <= k)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
