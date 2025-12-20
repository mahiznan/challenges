package com.mahiznan.faang;

import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddOneToLinkedList {

    int recursive(ListNode node) {
        if (node.next == null) {
            node.data = (node.data + 1) % 10;
            if (node.data == 0)
                return 1;
            return 0;
        }
        int toAdd = recursive(node.next);
        node.data = (node.data + toAdd) % 10;
        if (node.data == 0)
            return 1;
        return 0;
    }

    ListNode addOneToList(ListNode head) {
        int toAdd = recursive(head);
        ListNode newHead = head;
        if (toAdd == 1) {
            newHead = new ListNode(1);
            newHead.next = head;
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        AddOneToLinkedList obj = new AddOneToLinkedList();
        ListNode result = obj.addOneToList(head);
        while (result != null) {
            if (result.next != null)
                System.out.print(result.data + "->");
            else System.out.print(result.data);
            result = result.next;
        }

    }
}
