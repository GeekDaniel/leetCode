package com.dannystone;

import lombok.val;

/**
 * Created with IntelliJ IDEA.
 * Description: 本例和AddTwoNumbers 都是使用的是迭代的思想。相比下AddTwoNumbers 细节处理叫重复冗余
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/29 12:05 AM
 */
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = null, prev = null;
        int value = 0;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                value = l1.val;
                l1 = l1.next;
            } else {
                value = l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode(value);
            //头结点初始化
            if (head == null) {
                head = newNode;
            }

            if (prev != null) {
                prev.next = newNode;
            }

            prev = newNode;

        }

        if (l1 != null) {
            prev.next = l1;

        }
        if (l2 != null) {
            prev.next = l2;

        }

        return head;

    }
}
