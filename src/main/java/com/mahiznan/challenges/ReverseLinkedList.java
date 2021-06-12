package com.mahiznan.challenges;

import java.io.IOException;

public class ReverseLinkedList {
    static void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static LinkedListNode reverseListRecursion(LinkedListNode head) {
        if (head.next == null) {
            System.out.println("Next head is null for " + head.data);
            return head;
        }
        LinkedListNode newHead = reverseListRecursion(head.next);
        System.out.println("head is " + head.data);
        head.next.next = head;
        head.next = null;
        System.out.println("New head is " + head.data);
        return newHead;
    }

    //{10, 9, 8, 7, 2};
    static LinkedListNode reverseList(LinkedListNode head) {
        if (head.next == null) {
            return head;
        }
        LinkedListNode tail = new LinkedListNode(head.data);
        LinkedListNode cNode = head.next;
        LinkedListNode tHead = null;
        while (cNode != null) {
            tHead = new LinkedListNode(cNode.data);
            tHead.next = tail;
            tail = tHead;
            cNode = cNode.next;
        }
        return tHead;
    }

    public static void main(String args[]) throws IOException {

        int n = 5;
        int[] arr = {10, 9, 8, 7, 2};
//        int n = 1;
//        int[] arr = {11};
        LinkedListNode head = new LinkedListNode(arr[0]);
        LinkedListNode tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new LinkedListNode(arr[i]);
            tail = tail.next;
        }
        //reverseList(head);
        printList(reverseListRecursion(head));
    }
}

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int x) {
        data = x;
        next = null;
    }

}

