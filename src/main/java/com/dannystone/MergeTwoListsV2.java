package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description: 本例和AddTwoNumbers 都是使用的是递归
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/29 12:05 AM
 */
public class MergeTwoListsV2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //特判
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
