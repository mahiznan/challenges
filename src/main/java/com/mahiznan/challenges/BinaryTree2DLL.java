package com.mahiznan.challenges;

import com.mahiznan.util.Node;

public class BinaryTree2DLL {

    static Node prev;
    static Node head = null;

    static void fixLeftPointer(Node node) {
        if (node == null) return;

        fixLeftPointer(node.left);
        node.left = prev;
        prev = node;
        fixLeftPointer(node.right);
    }

    static Node fixRightPointer(Node node) {
        while (node.right != null) {
            node = node.right;
        }

        while (node.left != null) {
            Node t = node.left;
            t.right = node;
            node = node.left;
        }
        return node;
    }

    //Approach 2
    static Node buildDLLApproach2(Node root) {
        prev = null;
        fixLeftPointer(root);
        return fixRightPointer(root);
    }

    static Node buildDLLApproach3(Node node) {
        if (node == null) {
            return null;
        }
        buildDLLApproach3(node.left);
        if (prev == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        buildDLLApproach3(node.right);
        return head;
    }


    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(12);
        Node node3 = new Node(25);
        Node node4 = new Node(30);
        Node node5 = new Node(15);
        Node node6 = new Node(36);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;

        Node head;

        /*
        head = buildDLL(node1);
        while (head.left != null) {
            head = head.left;
        }

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.right;
        }


        head = buildDLLApproach2(node1);
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.right;
        }*/

        head = buildDLLApproach3(node1);
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.right;
        }

    }

    //Approach 1
    static Node buildDLL(Node root) {
        if (root == null)
            return null;
        Node node = new Node(root.data);

        if (root.left != null) {
            Node left = buildDLL(root.left);
            while (left.right != null)
                left = left.right;
            node.left = left;
            left.right = node;
        }

        if (root.right != null) {
            Node right = buildDLL(root.right);
            while (right.left != null)
                right = right.left;
            node.right = right;
            right.left = node;
        }
        return node;
    }


}
