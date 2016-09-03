package day18;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/9/3 16:10
 * Version: 1.0
 */
public class HouseRobber {

    public static int rob_wrong(int[] nums) {
        // 用来处理下标
        int[] numbers = nums.clone();
        // 排序
        int[] sorted = nums.clone();
        int length = nums.length;
        int[] index = new int[length];

        System.out.println(Arrays.toString(numbers));
        int p = 0;
        Arrays.sort(sorted);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (sorted[i] == numbers[j]) {
                    index[p++] = j;
                    // 防止下标冲突
                    numbers[j] = -1;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(index));

        // 盗窃总和
        // 标记是否已经盗窃过
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            if (list.contains(index[i] + 1) || list.contains(index[i] - 1)) {
                // 说明相邻家庭
            } else {
                sum += sorted[i];
                list.add(index[i]);
                System.out.print(sorted[i] + ":" + index[i] + " ");
            }
        }
        int sum0 = 0;
        list.clear();
        for (int i = 0; i < length; i++) {
            if (list.contains(index[i] + 1) || list.contains(index[i] - 1)) {
                // 说明相邻家庭
            } else {
                sum0 += sorted[i];
                list.add(index[i]);
                System.out.print(sorted[i] + ":" + index[i] + " ");
            }
        }

        return Math.max(sum, sum0);
    }

    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        //Initialize an arrays to store the money
        int[] mark = new int[nums.length];

        //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
        //so initialize two nums at first.
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);

        //Using Dynamic Programming to mark the max money in loop.
        for(int i=2;i<nums.length;i++){
            mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
        }
        return mark[nums.length-1];
    }


    public static void main(String[] args) {
        int[] ints = {1, 3, 1};
        rob_wrong(ints);
    }

}
