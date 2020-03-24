package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/20 4:05 PM
 */
public class LinkedListReverse {
    static class Node {

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        int value;

        Node next;
    }

    public static void main(String[] args) {
        //prepare
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        printLinkedList(node1);

        //inverse
        Node reverse = reverse(node1);

        printLinkedList(reverse);


    }

    private static void printLinkedList(Node node) {
        Node cursor = node;
        while (cursor != null) {
            System.out.println("value : " + cursor.getValue());
            cursor = cursor.next;
        }

    }

    private static Node reverse(Node head) {
        Node reversedHead = null;

        while (head != null) {
            Node tmp = head;
            head = head.next;
            tmp.next = reversedHead;
            reversedHead = tmp;
        }

        return reversedHead;

    }

}
