package day01;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/7/31 11:03
 * Version: 1.0
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        Integer integer = null;
        for (int i = 0, count = 0; i < s.length(); i++) {
            integer = sMap.get(s.charAt(i));
            count = (integer == null) ? 0 : integer;
            sMap.put(s.charAt(i), count + 1);

            integer = tMap.get(t.charAt(i));
            count = (integer == null) ? 0 : integer;
            tMap.put(t.charAt(i), count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            integer = sMap.get(ch);
            int cs = integer == null ? 0 : integer;

            integer = tMap.get(ch);
            int ts = integer == null ? 0 : integer;
            if (cs != ts) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }

}
