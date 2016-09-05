package day19;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/9/5 20:19
 * Version: 1.0
 */
public class ReverseVowelsString {

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (isVowels(chars[i])) {
                stack.push(chars[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (isVowels(chars[i])) {
                chars[i] = stack.pop();
            }
        }
        return String.copyValueOf(chars);
    }

    public static boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        String leetcode = reverseVowels("aA");
        System.out.println(leetcode);

    }

}
