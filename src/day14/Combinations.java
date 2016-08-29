package day14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/29 16:54
 * Version: 1.0
 */
public class Combinations {

// Basically,
// this solution follows the idea of
// the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).

// Here C(n,k) is divided into two situations.
// Situation one, number n is selected,
// so we only need to select k-1 from n-1 next.
// Situation two, number n is not selected,
// and the rest job is selecting k from n-1.


//    https://discuss.leetcode.com/topic/12537/a-short-recursive-java-solution-based-on-c-n-k-c-n-1-k-1-c-n-1-k
//    if (k == n || k == 0) {
//        List<Integer> row = new LinkedList<>();
//        for (int i = 1; i <= k; ++i) {
//            row.add(i);
//        }
//        return new LinkedList<>(Arrays.asList(row));
//    }
//    List<List<Integer>> result = this.combine(n - 1, k - 1);
//    result.forEach(e -> e.add(n));
//    result.addAll(this.combine(n - 1, k));
//    return result;

    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            LinkedList<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; i++) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }


    public static void main(String[] args) {

    }

}
