package com.mahiznan.faang;

/*
A path between two nodes p and q is defined as a sequence of nodes encountered while travelling from node p to node q (or vice-versa) via parent-child connections. The path does not need to pass through the root node. The sum of the values of all these nodes in the path is considered as the path sum.

A binary tree can have multiple paths depending on the number of nodes. Thus, the path with the maximum sum is considered the maximum path sum for the tree. Note that the path can be empty, i.e. contain no nodes.

Given the reference to the root node of a binary tree, return its maximum path sum.

Testing
Input Format
The first line contains an integer T denoting the number of test cases.

For each test case, the input has 2 lines:

The first line contains an integer n denoting the number of nodes in the tree (including the NULL nodes).
The second line contains n space-separated integers that will form the binary tree. The integers follow level order traversal of the tree where -9999 indicates a NULL node.
Output Format
For each test case, the output contains a line with the maximum path sum.

Sample Input
5
7
1 2 -9999 4 -9999 5 6
3
6 -9999 -4
7
8 -9999 -9 -9999 10 11 12
5
28 14 11 -9999 48
1
-6
Expected Output
15
6
33
101
-6
1 <= T <= 10
1 <= n <= 105
-1000 <= node value <= 1000
 */
public class MaximumPathSumOfBinaryTree {

    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    int maxPathSum(Node root) {
        return 0;
    }

    public static void main(String[] args) {
        MaximumPathSumOfBinaryTree solution = new MaximumPathSumOfBinaryTree();
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        one.left = two;
        two.left = four;
        four.left = five;
        four.right = six;
        System.out.println(solution.maxPathSum(one));

    }
}
