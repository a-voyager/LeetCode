package day08;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/11 12:29
 * Version: 1.0
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        int[] arrayA = getIntArray(a);
        int[] arrayB = getIntArray(b);
        int[] result = new int[24];
        int i = 0;
        for (i = 1; i < Math.max(arrayA[0], arrayB[0]); i++) {
            int r = arrayA[i] + arrayB[i] + result[i];
            if (r > 9) {
                result[i] = r % 10;
                result[i + 1] += 1;
            } else {
                result[i] = r;
            }
        }
        result[0] = i;

        int sum = 0;
        for (i = result[0]; i > 0; i--) {
            sum = sum * 10 + result[i];
        }
        return sum;
    }

    private static int[] getIntArray(int a) {
        int[] result = new int[24];
        int i = 1;
        while (a != 0) {
            result[i++] = a % 10;
            a /= 10;
        }
        result[0] = i;
        return result;
    }


    public static void main(String[] args) {
        int sum = getSum(512, -512);
        System.out.println(sum);
    }

}
