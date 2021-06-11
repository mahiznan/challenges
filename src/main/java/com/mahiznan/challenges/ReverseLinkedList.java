package com.mahiznan.challenges;

import java.io.IOException;
import java.util.Scanner;

public class ReverseLinkedList {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node reverseListRecursion(Node head) {
        if (head.next == null) {
            System.out.println("Next head is null for " + head.data);
            return head;
        }
        Node newHead = reverseListRecursion(head.next);
        System.out.println("head is " + head.data);
        head.next.next = head;
        head.next = null;
        System.out.println("New head is " + head.data);
        return newHead;
    }

    //{10, 9, 8, 7, 2};
    static Node reverseList(Node head) {
        if (head.next == null) {
            return head;
        }
        Node tail = new Node(head.data);
        Node cNode = head.next;
        Node tHead = null;
        while (cNode != null) {
            tHead = new Node(cNode.data);
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
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        //reverseList(head);
        printList(reverseListRecursion(head));
    }
}

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

