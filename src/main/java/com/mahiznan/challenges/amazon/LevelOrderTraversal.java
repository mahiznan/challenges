package com.mahiznan.challenges.amazon;


import com.mahiznan.util.Node;

import java.util.*;

public class LevelOrderTraversal {

    static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        if (lHeight > rHeight)
            return lHeight + 1;
        return rHeight + 1;
    }

    static void print(Node node, List<Integer> elements, int level) {
        if (node == null)
            return;
        if (level == 1) {
            elements.add(node.data);
        } else if (level > 1) {
            print(node.left, elements, level - 1);
            print(node.right, elements, level - 1);
        }
    }

    //Approach 1
    static void printRecursive(Node node) {
        int height = height(node);
        List<Integer> elements = new ArrayList<>();
        for (int i = height; i >= 1; i--) {
            print(node, elements, i);
            System.out.println(elements);
            elements.clear();
        }
    }

    //Approach 2 (Using single Queue)
    static void printUsingQueue(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    //Approach 3 Using 2 Queues
    static void printUsingTwoQueue(Node node) {
        Queue<Node> currentQueue = new LinkedList<>();
        Queue<Node> nextQueue = new LinkedList<>();

        currentQueue.add(node);
        while (!currentQueue.isEmpty()) {
            Node t = currentQueue.poll();
            System.out.println(t.data + " ");
            if (t.left != null) {
                nextQueue.add(t.left);
            }
            if (t.right != null) {
                nextQueue.add(t.right);
            }

            if (currentQueue.isEmpty()) {
                System.out.println();
                Queue<Node> temp = nextQueue;
                nextQueue = currentQueue;
                currentQueue = temp;
            }
        }

    }

    static String printUsingQueuePractice(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        StringBuilder s = new StringBuilder();
        while (!queue.isEmpty()) {
            node = queue.poll();
//            System.out.print(" " + node.data);
            s.append(node.data);
            s.append(",");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return s.toString();
    }

    public static void main(String[] args) {

        Node node1 = new Node(100);
        Node node2 = new Node(50);
        Node node3 = new Node(200);
        Node node4 = new Node(25);
        Node node5 = new Node(75);
        Node node6 = new Node(350);
        Node node7 = new Node(150);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node3.left = node7;


//        printRecursive(node1);
//        printUsingQueue(node1);
        printUsingTwoQueue(node1);
//        System.out.println(printUsingQueuePractice(node1));
    }
}
