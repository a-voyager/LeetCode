package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/6 18:55
 * Version: 1.0
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        int lastIndex = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i + 1 == length || nums[i + 1] != nums[i] + 1) {
                if (lastIndex != i)
                    list.add(nums[lastIndex] + "->" + nums[i]);
                else
                    list.add(nums[i] + "");
                lastIndex = i + 1;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] src = {0, 1, 2, 4, 5, 7, 8};
        List<String> strings = summaryRanges(src);
        System.out.println(strings.toString());
    }

}
