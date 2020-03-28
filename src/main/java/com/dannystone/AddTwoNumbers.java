package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/28 5:08 PM
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int promote = 0, value = 0;
        int l1Value = 0, l2Value = 0;
        ListNode newNode = null, lastNode = null;
        while (promote != 0 || l1 != null || l2 != null) {

            if (l1 != null) {
                l1Value = l1.val;
            } else {
                l1Value = 0;
            }

            if (l2 != null) {
                l2Value = l2.val;
            } else {
                l2Value = 0;
            }
            value = (l1Value + l2Value + promote) % 10;
            promote = (l1Value + l2Value + promote) / 10;
            ListNode listNode = new ListNode(value);

            if (newNode == null) {
                newNode = listNode;
            } else {
                lastNode.next = listNode;
            }

            lastNode = listNode;

            if (l1 == null) {
            } else if (l1.next == null) {
                l1 = null;
            } else {
                l1 = l1.next;
            }

            if (l2 == null) {
            } else if (l2.next == null) {
                l2 = null;
            } else {
                l2 = l2.next;
            }

        }

        return newNode;

    }
}
