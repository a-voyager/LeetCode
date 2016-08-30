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
        StringBuilder builder = new StringBuilder();
        int num = n;
        while (num-- != 0) {
            char c = (char) (num % 26 + 'A');
            builder.append(c);
            num /= 26;
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        String s = convertToTitle(29);
        System.out.println(s);
    }

}
