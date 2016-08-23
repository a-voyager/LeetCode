package day11;

/**
 * https://leetcode.com/problems/power-of-two/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/23 15:41
 * Version: 1.0
 */
public class PowerTwo {

    public static boolean isPowerOfTwo(int n) {
        int num = n;
        while (num > 0) {
            if (num % 2 != 0) return num == 1;
            num /= 2;
        }
        return false;
    }

    public static boolean isPowerOfTwo_BETTER(int n) {
        return n > 0 && (n & n - 1) == 0;
    }


    public static void main(String[] args) {
        long before = System.nanoTime();
        boolean powerOfTwo = isPowerOfTwo(10000);
        System.out.println(powerOfTwo);
        System.out.println(System.nanoTime() - before);
    }

}
