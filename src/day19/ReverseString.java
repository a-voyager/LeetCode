package day19;

/**
 * https://leetcode.com/problems/reverse-string/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/9/5 20:40
 * Version: 1.0
 */
public class ReverseString {

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseStringNew(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int n = length - 1;
        for (int i = n >> 1; i >= 0; i--) {
            int k = n - i;
            char ci = chars[i];
            char ck = chars[k];
            chars[i] = ck;
            chars[k] = ci;
        }
        return String.copyValueOf(chars);
    }


    public static void main(String[] args) {
        String s = reverseStringNew("");
        System.out.println(s);
    }

}
