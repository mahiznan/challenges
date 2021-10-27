package com.mahiznan.challenges;

import java.util.LinkedList;
import java.util.Queue;

public class MergeLinkedList {

    Queue<Integer> k = new LinkedList<>();

    public static LinkedListNode merge_sorted(
            LinkedListNode head1,
            LinkedListNode head2) {
        LinkedListNode mergedHead, mergedTail;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }
        mergedTail = mergedHead;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                mergedTail.next = head1;
                head1 = head1.next;
            } else {
                mergedTail.next = head2;
                head2 = head2.next;
            }
            mergedTail = mergedTail.next;
        }

        if (head1 != null) {
            mergedTail.next = head1;
        }
        if (head2 != null) {
            mergedTail.next = head2;
        }
        return mergedHead;
    }

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(4);
        LinkedListNode node2 = new LinkedListNode(8);
        LinkedListNode node3 = new LinkedListNode(15);
        LinkedListNode node4 = new LinkedListNode(19);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        LinkedListNode node5 = new LinkedListNode(7);
        LinkedListNode node6 = new LinkedListNode(9);
        LinkedListNode node7 = new LinkedListNode(10);
        LinkedListNode node8 = new LinkedListNode(16);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        LinkedListNode head = merge_sorted(node1, node5);
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
}
