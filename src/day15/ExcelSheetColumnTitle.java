package day15;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/30 22:44
 * Version: 1.0
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        if (n <= 0) return null;
        String s = Integer.toString(n, 26);
        char[] array = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int original = Integer.parseInt(array[i] + "");
//            if (original > 0) {
//                char ch = (char) (original - 1 + 'A');
//                builder.append(ch);
//            }
            char ch = (char) (original - 1 + 'A');
            System.out.println(original + " : " + ch);
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        String s = convertToTitle(26);
        System.out.println(s);
    }

}
