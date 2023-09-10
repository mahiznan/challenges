package com.mahiznan.faang;

import java.util.HashMap;
import java.util.Map;

/*
Given a linked list, delete the xth node from the end.

Example:
Linked list: 1→2→3→4

x: 2

Result: 1→2→4

Testing
Input Format
The first line contains an integer ‘T’ denoting the number of independent test cases.

For each test case the input has three lines:

An integer ‘n’ denoting the length of the linked list.
n space-separated integers denoting elements of the linked list.
An integer ‘x’ denoting the xth element from the end to be deleted.
Output Format
For each test case, a line which contains space-separated integers denoting the elements of the resultant link list.

Sample Input
2
3
3 4 5
2
3
1 0 1
1
Expected Output
3 5
1 0
Constraints
1 <= T <= 100
1 <= n <= 104
1 <= x <= n
1 <= element <= 105
 */
public class LinkedListDeleteNodeFromLast {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static ListNode removeXthNodeFromEnd_Best(ListNode head, int x) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < x; i++) {
            fast = fast.next;
        }
        if (fast.next == null) {
            return head.next;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        print(head);
        return head;
    }

    static ListNode removeXthNodeFromEnd_Good(ListNode head, int x) {
        if (head == null)
            return head;
        Map<Integer, ListNode> map = new HashMap<>();
        int pos = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            map.put(pos++, currentNode);
            currentNode = currentNode.next;
        }
        ListNode nodeToBeDeleted = map.get(pos - x);
        if (nodeToBeDeleted == null)
            return head;
        if (nodeToBeDeleted == head) {
            return head.next;
        }
        ListNode node = map.get(pos - x - 1);
        node.next = node.next != null ? node.next.next : null;
        print(head);
        return head;
    }

    static void print(ListNode node) {
        while (node != null) {
            if (node.next != null)
                System.out.print(node.data + "->");
            else
                System.out.print(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        removeXthNodeFromEnd_Good(node1, 1);
        removeXthNodeFromEnd_Best(node1, 3);
    }
}
