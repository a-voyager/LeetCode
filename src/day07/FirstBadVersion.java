package day07;

/**
 * https://leetcode.com/problems/first-bad-version/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/10 12:23
 * Version: 1.0
 */
public class FirstBadVersion {

    static boolean isBadVersion(int version) {
        return version >= 1;
    }

    public static int firstBadVersion(int n) {
        long right = n, left = 1;
        long mid = 0;
        while (right != left + 1 && right > left) {
            mid = (right + left) / 2;
            if (isBadVersion((int) mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right == left + 1) return (int) (isBadVersion((int) left) ? left : right);
        return (int) right;
    }


    public static int firstBadVersion_good(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

}
