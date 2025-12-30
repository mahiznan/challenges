package com.mahiznan.faang;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    int[] zigzagLevelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            System.out.print(node.data + " ");
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal tree = new BinaryTreeZigzagLevelOrderTraversal();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        six.left = eight;
        five.left = seven;
        tree.zigzagLevelOrderTraversal(one);
    }

}
