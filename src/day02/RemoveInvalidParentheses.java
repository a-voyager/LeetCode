package day02;

import java.util.*;

/**
 * 去除无效的圆括号
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/1 12:14
 * Version: 1.0
 */
public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        Set<String> sets = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        Stack<Character> parentheses = new Stack<>();
        StringBuilder stringBuilder;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') len++;
        }

        for (int j = len; j >= 0; j--) {
            stringBuilder = new StringBuilder();
            for (int i = 0, rightParCount = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(':
                        stringBuilder.append(c);
                        parentheses.add(c);
                        break;
                    case ')':
                        rightParCount++;
                        if (rightParCount - 1 == j) {
                            continue;
                        }
                        if (parentheses.isEmpty()) {
                            continue;
                        }
                        if (parentheses.pop() == '(') {
                            stringBuilder.append(c);

                        }
                        break;
                    default:
                        stringBuilder.append(c);
                        break;
                }
            }
            String str = stringBuilder.toString();
            if (!str.endsWith("(")) {
                sets.add(stringBuilder.toString());
            }
            if (stringBuilder.toString().endsWith("(")) {
                while (stringBuilder.toString().endsWith("(")) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                if (!stringBuilder.toString().endsWith(")") && !stringBuilder.toString().isEmpty())
                    sets.add(stringBuilder.toString());
            }
        }
        if (sets.isEmpty())
            sets.add("");
        for (String str : sets) {
            list.add(str);
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> strings = removeInvalidParentheses("()");
        System.out.println(strings.toString());
    }
}
