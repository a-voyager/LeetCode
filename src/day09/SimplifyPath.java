package day09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/simplify-path/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/17 21:50
 * Version: 1.0
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        System.out.println(Arrays.toString(split));
        for (String s : split) {
            if (s.equals("..")) {
                if (!deque.isEmpty())
                    deque.pop();
            } else if (!s.equals(".") && !s.isEmpty()) deque.push(s);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append("/").append(deque.pollLast());
        }
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = simplifyPath("/..");
        System.out.println(path);
    }

}
