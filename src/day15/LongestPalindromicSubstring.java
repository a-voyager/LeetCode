package day15;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/30 18:02
 * Version: 1.0
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int length = str.length;
        if (length == 1) return s;
        int max = 0;
        String result = "";
        for (int i = 0; i < length; i++) {
            // 对于 level 型
            if (i + 2 < length && str[i] == str[i + 2]) {
                //    l        e         v       e        l
                // (i+1)-2  i=(i+1)-1  (i+1)  (i+1)+1  (i+1)+2
                //   t=2       t=1      t=0      t=1      t=2
                int t = 1;
                while (((i + 1) + t) < length
                        && ((i + 1) - t) >= 0
                        && str[(i + 1) - t] == str[(i + 1) + t])
                    t++;
                t--;
                if ((2 * t + 1) >= max) {
                    result = s.substring((i + 1) - t, ((i + 1) + t) + 1);
                    max = (2 * t + 1);
                }
            }
            // 对于 abba 型
            if (i + 1 < length && str[i] == str[i + 1]) {
                //  a   b    b    a
                // i-1  i   i+1  i+2
                int t = 1;
                while (((i + 1) + t) < length
                        && (i - t) >= 0
                        && str[i - t] == str[(i + 1) + t])
                    t++;
                t--;
                if ((2 * t + 2) >= max) {
                    result = s.substring(i - t, (i + t) + 2);
                    max = (2 * t + 2);
                }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz");
        System.out.println(s);
    }

}
