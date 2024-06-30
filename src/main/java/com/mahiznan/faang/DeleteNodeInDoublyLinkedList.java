package com.mahiznan.faang;

/*

Given a doubly Linked list and a position. The task is to delete a node from a given position (position starts from 1)
in a doubly linked list and return the head of the doubly Linked list.

Examples:

Input: LinkedList = 1 <--> 3 <--> 4, x = 3
Output: 1 3
Explanation:
After deleting the node at position 3 (position starts from 1),the linked list will be now as 1 <--> 3.

Input: LinkedList = 1 <--> 5 <--> 2 <--> 9, x = 1
Output: 5 2 9
Explanation:

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 <= size of the linked list(n) <= 105
1 <= x <= n
1 <= node.data <= 109
 */

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class DeleteNodeInDoublyLinkedList {
    static Node deleteNode(Node head, int x) {
        if (x == 1)
            return head.next;
        int cp = 1;
        Node cHead = head;
        while (cp < x) {
            cp++;
            cHead = cHead.next;
        }
        cHead.prev.next = cHead.next;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node2.prev = node1;
        node3.prev = node2;
        Node head = deleteNode(node1, 1);

        while (head != null) {
            System.out.println(head.data + "->");
            head = head.next;
        }

    }
}

