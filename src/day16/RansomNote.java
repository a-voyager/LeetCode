package day16;

/**
 * https://leetcode.com/problems/ransom-note/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/31 8:07
 * Version: 1.0
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        int ranLen = ran.length;
        int[] letter = new int[26];
        for (int i = 0; i < ranLen; i++) {
            letter[ran[i] - 'a']++;
        }
        char[] mag = magazine.toCharArray();
        int magLen = mag.length;
        for (int i = 0; i < magLen; i++) {
            letter[mag[i] - 'a']--;
        }
        int letterLen = letter.length;
        for (int i = 0; i < letterLen; i++) {
            if (letter[i] > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = canConstruct("aa", "aab");
        System.out.println(b);
    }

}
