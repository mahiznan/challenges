package com.mahiznan.faang;

import java.util.List;

/*
Given two sorted linked lists, merge them inplace to produce a singular sorted linked list.

Example:

A: 2→3→7

B: 1→4→5

Resultant list, after merging A and B:

C: 1→2→3→4→5→7

Testing
Input
The first line contains ‘T’ denoting the no of independent test cases.

For each test case the input has three lines:

Two space-separated intergers ‘n’ and ‘m’ denoting the size of the first list and second list respectively.
n space-separated integers denoting the elements of first list.
m space-separated integers denoting the elements of second list.
Output
For each test case, a line containing n+m space-separated integers denoting the elements of merged linked list.

Sample Input
2
3 4
1 2 3
2 2 4 5
3 3
2 3 3
1 4 5
Expected output
1 2 2 2 3 4 5
1 2 3 3 4 5
Constraints
1 <= T <= 100
1 <= n, m <= 1000
1 <= elements <= 106
 */
public class MergeSortedLinkedList {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static ListNode mergeTwoSortedList(ListNode firstList, ListNode secondList) {
        if (firstList == null)
            return secondList;
        if (secondList == null)
            return firstList;
        ListNode head, pointer;
        if (firstList.data < secondList.data) {
            head = firstList;
            firstList = firstList.next;
        } else {
            head = secondList;
            secondList = secondList.next;
        }
        pointer = head;
        while (firstList != null && secondList != null) {
            while (firstList.data < secondList.data) {
                pointer.next = firstList;
                firstList = firstList.next;
                pointer = pointer.next;
            }
            while (secondList.data < firstList.data) {
                pointer.next = secondList;
                secondList = secondList.next;
                pointer = pointer.next;
            }
        }
        if (firstList == null)
            pointer.next = secondList;
        else
            pointer.next = firstList;
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
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode mergedList = mergeTwoSortedList(node1, node4);
        print(mergedList);

    }
}
