package day10;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/8/22 22:46
 * Version: 1.0
 */
public class SwapNodesPairs {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode temp;
        while (curr.next != null) {
            temp = curr.next;
            curr.next = temp;
            temp.next = curr;
            curr = temp;

            curr = curr.next.next;
        }
        return head;
    }


    public ListNode swapPairs_RIGHT(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

}
