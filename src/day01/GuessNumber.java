package day01;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/7/31 17:15
 * Version: 1.0
 */
public class GuessNumber {

    public static int guess(int n) {
        int real = 6;
        if (n > real) return -1;
        else if (n < real) return 1;
        else return 0;
    }

    public static int guessNumber(int n) {
        long result, number = 0, high = n, low = 0;
        result = guess((int)number);
        while (result != 0) {
            if (result == 1) {
                low = number + 1;
            }
            if (result == -1) {
                high = number - 1;
            }
            number = (low + high) / 2;
            result = guess((int)number);
        }
        return (int)number;
    }

    public static void main(String[] args) {
        long before = System.nanoTime();
        int i = guessNumber(10);
        System.out.println(i);
        System.out.println(System.nanoTime() - before);
    }

}
