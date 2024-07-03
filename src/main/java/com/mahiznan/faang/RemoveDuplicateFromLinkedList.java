package com.mahiznan.faang;

/*
Remove all occurrences of duplicates in a linked list
Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences), leaving only numbers
that appear once in the original list, and return the head of the modified linked list.
Examples:

Input: Linked List = 23->28->28->35->49->49->53->53
Output: 23 35
Explanation:

The duplicate numbers are 28, 49 and 53 which are removed from the list.
Input: Linked List = 11->11->11->11->75->75
Output: Empty list
Explanation:

All the nodes in the linked list have duplicates. Hence the resultant list would be empty.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ size(list) ≤ 105

Company Tags
Microsoft

 */

public class RemoveDuplicateFromLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public static void main(String[] args) {
        //23->28->28->35->49->49->53->53

        /*Node node1 = new Node(23);
        Node node2 = new Node(28);
        Node node3 = new Node(28);
        Node node4 = new Node(35);
        Node node5 = new Node(49);
        Node node6 = new Node(49);
        Node node7 = new Node(53);
        Node node8 = new Node(53);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;*/

        //11->11->11->11->75->75

        Node node1 = new Node(11);
        Node node2 = new Node(11);
        Node node3 = new Node(11);
        Node node4 = new Node(11);
        Node node5 = new Node(75);
        Node node6 = new Node(75);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node head = removeAllDuplicates(node1);
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.data + " -> ");
            } else {
                System.out.print(head.data);
            }
            head = head.next;
        }
    }

    public static Node removeAllDuplicates(Node head) {
        Node headNode = null;
        Node prevNode = null;
        Node currNode = head;
        boolean found = false;
        while (currNode != null) {
            while ((currNode != null && currNode.next != null && currNode.data == currNode.next.data) || found) {
                found = currNode.next != null && currNode.data == currNode.next.data;
                currNode = currNode.next;
            }
            if (prevNode != null) {
                prevNode.next = currNode;
            } else {
                headNode = currNode;
            }
            prevNode = currNode;
            if (currNode != null) {
                currNode = currNode.next;
            }
        }
        return headNode;
    }

    public static Node removeAllDuplicatesOption2(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(0); // Dummy node to handle edge cases
        dummy.next = head;
        Node prevNode = dummy;
        Node currNode = head;
        while (currNode != null) {
            boolean isDuplicate = false;
            while (currNode.next != null && currNode.data == currNode.next.data) {
                currNode = currNode.next;
                isDuplicate = true;
            }
            if (isDuplicate) {
                prevNode.next = currNode.next;
            } else {
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
        return dummy.next;
    }
}
