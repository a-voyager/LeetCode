package day03;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/4 3:11
 * Version: 1.0
 */
public class LongestValidParentheses {

    /**
     * 注意点：
     * 1. 要求的是连续的括号，而不是包含的括号
     * Input: "()(()"
     * Output: 4
     * Expected: 2
     */
//    1. Scan the string from beginning to end.
//    2. If current character is '(',
//       push its index to the stack. If current character is ')' and the
//       character at the index of the top of stack is '(', we just find a
//       matching pair so pop from the stack. Otherwise, we push the index of
//       ')' to the stack.
//    3. After the scan is done, the stack will only
//       contain the indices of characters which cannot be matched. Then
//       let's use the opposite side - substring between adjacent indices
//       should be valid parentheses.
//    4. If the stack is empty, the whole input
//       string is valid. Otherwise, we can scan the stack to get longest
//       valid substring as described in step 3.
    public static int longestValidParentheses(String s) {
        char[] str = s.toCharArray();
        int length = str.length;
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < length; i++) {
            switch (str[i]) {
                case '(':
                    stack.push(i);
                    break;
                case ')':
                    if (!stack.isEmpty() && str[stack.peek()] == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                    break;
            }
        }
        if (stack.isEmpty()) count = length;
            // 1. 防止()(()输出4
            // 记录余下的)的坐标 找到最先放的坐标
            // 2. 防止(()输出0
        else {
            int a = length, i = 0;
            while (!stack.isEmpty()) {
                i = stack.peek();
                stack.pop();
                count = Math.max(count, a - i - 1);
                a = i;
            }
            count = Math.max(count, a);
        }
        return count;

    }


//    public static int longestValidParentheses(String s) {
//        char[] str = s.toCharArray();
//        int length = str.length;
//        if (length == 1) return 0;
//        Stack<Character> stack = new Stack<>();
//        int count = 0;
//        boolean isFirstRight = false;
//        boolean isFirstLeft = false;
//        for (int i = 0; i < length; i++) {
//            switch (str[i]) {
//                case '(':
//                    stack.add(str[i]);
//                    isFirstRight = true;
//                    break;
//                case ')':
//                    if (!stack.isEmpty() && stack.peek() == '(') {
//                        stack.pop();
//                        count += 2;
//                    } else if (isFirstRight && !stack.isEmpty() && stack.peek() != '(') {
//                        return count;
//                    }
//                    if (!isPair(s.substring(i + 1))) return count;
//                    break;
//            }
//        }
//        return count;
//    }


    public static boolean isPair(String src) {
        char[] str = src.toCharArray();
        int length = str.length;
        if (length != 1 && src.startsWith(")")) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            switch (str[i]) {
                case '(':
                    stack.add(str[i]);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        if (stack.size() == 0) return true;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

}
