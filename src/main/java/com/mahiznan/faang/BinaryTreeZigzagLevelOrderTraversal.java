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
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> forwardStack = new Stack<>();
        Stack<Node> reverseStack = new Stack<>();
        forwardStack.add(root);
        list.add(root.data);
        while (!forwardStack.isEmpty()) {
            while (!forwardStack.isEmpty()) {
                Node node = forwardStack.pop();
                if (node.right != null) {
                    reverseStack.add(node.right);
                    list.add(node.right.data);
                }
                if (node.left != null) {
                    reverseStack.add(node.left);
                    list.add(node.left.data);
                }
            }
            while (!reverseStack.isEmpty()) {
                Node node = reverseStack.pop();
                if (node.left != null) {
                    forwardStack.add(node.left);
                    list.add(node.left.data);
                }
                if (node.right != null) {
                    forwardStack.add(node.right);
                    list.add(node.right.data);
                }
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
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
        System.out.println(Arrays.toString(tree.zigzagLevelOrderTraversal(one)));
    }

}
