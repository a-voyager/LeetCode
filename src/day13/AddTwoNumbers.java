package day13;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/28 13:59
 * Version: 1.0
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result = null;
        ListNode pointer = null;
        int sum = 0, flag = 0;
        while (t1 != null && t2 != null) {
            sum = t1.val + t2.val + flag;
            if (result == null) {
                result = new ListNode(sum % 10 );
                pointer = result;
            } else {
                pointer.next = new ListNode(sum % 10 );
                pointer = pointer.next;
            }
            flag = sum / 10;
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1 != null){
            t1.val += flag;
            flag = 0;
        }
        while (t1 != null) {
            sum = t1.val +flag ;
            if (result == null) {
                result = new ListNode(sum%10);
                pointer = result;
            } else {
                pointer.next = new ListNode(sum%10);
                pointer = pointer.next;
            }
            flag = sum/10;
            t1 = t1.next;
        }
        if(t2 != null){
            t2.val += flag;
            flag = 0;
        }
        while (t2 != null) {
            sum = t2.val + flag;
            if (result == null) {
                result = new ListNode(sum%10);
                pointer = result;
            } else {
                pointer.next = new ListNode(sum%10);
                pointer = pointer.next;
            }
            flag = sum/10;
            t2 = t2.next;
        }
        System.out.println(flag);
        if(t1 == null && t2 == null && flag != 0){
            pointer.next = new ListNode(flag);
            return result;
        }
        return result;
    }

}
