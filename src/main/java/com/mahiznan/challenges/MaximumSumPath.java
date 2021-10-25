package com.mahiznan.challenges;

public class MaximumSumPath {

    static int result = Integer.MIN_VALUE;


    static int maxSumPathPractice(Node node) {
        if (node == null) {
            return 0;
        }
        int current = node.data;
        int left = maxSumPathPractice(node.left);
        int right = maxSumPathPractice(node.right);
        int singleMax = Math.max(Math.max(left, right) + current, current);
        int totalMax = Math.max(singleMax, left + right + current);
        result = Math.max(result, totalMax);
        return singleMax;
    }


    static int maxSumPath(Node node) {
        if (node == null) {
            return 0;
        }
        int current = node.data;
        int left = maxSumPath(node.left);
        int right = maxSumPath(node.right);
        int singleMax = Math.max(current, Math.max(left, right) + current);
        int topMax = Math.max(singleMax, left + right + current);
        result = Math.max(topMax, result);
        System.out.println("Left " + left + ", Right " + right + ", Single Max " + singleMax + " topMax " + topMax + ",Result " + result);
        return singleMax;
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(2);
        Node node3 = new Node(20);
        Node node4 = new Node(1);
        Node node5 = new Node(10);
        Node node6 = new Node(-25);
        Node node7 = new Node(3);
        Node node8 = new Node(4);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        node6.left = node7;
        node6.right = node8;
//        maxSumPath(node1);
        maxSumPathPractice(node1);
        System.out.println(result);
    }
}
