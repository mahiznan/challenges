package com.mahiznan.challenges;


import java.util.HashMap;
import java.util.Map;

class LinkedListNodeWithArbitraryPointer {
    int data;
    LinkedListNodeWithArbitraryPointer next;
    LinkedListNodeWithArbitraryPointer arbitrary;

    LinkedListNodeWithArbitraryPointer(int data) {
        this.data = data;
    }
}

public class MergeLinkedListWithArbitraryPointer {

    static LinkedListNodeWithArbitraryPointer copy(LinkedListNodeWithArbitraryPointer head) {

        if (head == null) {
            return head;
        }
        Map<Integer, LinkedListNodeWithArbitraryPointer> map = new HashMap<>();
        LinkedListNodeWithArbitraryPointer temp = head, newHead, newTail;
        while (temp != null) {
            map.put(temp.data, new LinkedListNodeWithArbitraryPointer(temp.data));
            temp = temp.next;
        }

        newHead = map.get(head.data);
        newTail = newHead;
        head = head.next;
        while (head != null) {
            newTail.next = map.get(head.data);
            newTail.arbitrary = head.arbitrary != null ? map.get(head.arbitrary.data) : null;
            head = head.next;
            newTail = newTail.next;
        }
        newTail.next = null;
        return newHead;
    }

    static void print(LinkedListNodeWithArbitraryPointer head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.data);
            } else {
                System.out.print(head.data + "->");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNodeWithArbitraryPointer node1 = new LinkedListNodeWithArbitraryPointer(7);
        LinkedListNodeWithArbitraryPointer node2 = new LinkedListNodeWithArbitraryPointer(14);
        LinkedListNodeWithArbitraryPointer node3 = new LinkedListNodeWithArbitraryPointer(21);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node1.arbitrary = node3;
        node2.arbitrary = null;
        node3.arbitrary = node1;

        LinkedListNodeWithArbitraryPointer headCopy = copy(node1);

        print(node1);
        System.out.println();
        print(headCopy);
    }
}
