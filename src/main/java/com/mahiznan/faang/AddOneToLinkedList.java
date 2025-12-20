package com.mahiznan.faang;
/*
Add One to Linked List
Medium
50 / 50
Given a natural number in the form of a linked list, add 1 to it.

Examples
Linked List: 7→8→9
Resultant List: 7→9→0
Linked List: 9→9→9
Resultant List: 1→0→0→0
 */
import java.util.Stack;

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


    //Approach 2, Optimistic
    ListNode addOneToListApproach2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }

        ListNode cur = null, newHead = null;
        int carry = 1;
        while (!stack.isEmpty()) {
            int data = stack.pop();

            ListNode node = new ListNode((data + carry) % 10);
            node.next = cur;
            cur = node;
            carry = (data + carry) / 10;
        }
        if (carry == 1) {
            newHead = new ListNode(1);
            newHead.next = cur;
            return newHead;
        } else return cur;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        AddOneToLinkedList obj = new AddOneToLinkedList();
//        ListNode result = obj.addOneToList(head);
        ListNode result = obj.addOneToListApproach2(head);
        while (result != null) {
            if (result.next != null)
                System.out.print(result.data + "->");
            else System.out.print(result.data);
            result = result.next;
        }

    }
}
