package day03;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/4 15:00
 * Version: 1.0
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        char[] str = s.toCharArray();
        int length = str.length;
        if (length % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            switch (str[i]) {
                case '(':
                    stack.push(str[i]);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case '[':
                    stack.push(str[i]);
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case '{':
                    stack.push(str[i]);
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    break;

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

}
