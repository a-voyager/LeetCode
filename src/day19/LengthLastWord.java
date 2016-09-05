package day19;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/9/5 19:53
 * Version: 1.0
 */
public class LengthLastWord {

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return Character.isLetter(s.charAt(0)) ? 1 : 0;
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        while (!Character.isLetter(chars[i--]) && i >= 0) ;
        int count = ++i;
        for (; i >= 0; i--) {
            if (chars[i] == ' ' || chars[i] == '.') return count - i;
        }
        return count - i;
    }

    public static void main(String[] args) {
        int i = lengthOfLastWord("fr");
        System.out.println(i);
    }

}
