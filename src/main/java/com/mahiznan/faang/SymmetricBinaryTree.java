package com.mahiznan.faang;
/*
A binary tree is considered symmetric if it is a mirror image of itself,
i.e, it is symmetric around its root node.

Given the root node of a binary tree, determine whether it's symmetric.
Testing
Input Format
The first line contains an integer T denoting the number of test cases.

For each test case, the input has 2 lines:

The first line contains an integer n denoting the number of nodes in the tree (including the NULL nodes).
The second line contains n space-separated integers that will form the binary tree. The integers follow level order traversal of the tree where -1 indicates a NULL node.
Output Format
For each test case, the output contains a line with 1 or 0 based on whether the tree is symmetric or not respectively.

Sample Input
4
7
1 2 2 4 -1 -1 4
7
6 4 4 -1 2 -1 2
7
1 2 3 4 -1 -1 4
1
6
Expected Output
1
0
0
1
1 <= T <= 10
1 <= n <= 105
1 <= node value <= 106

 */


import java.util.ArrayList;

public class SymmetricBinaryTree {

    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    boolean checkSymmetric(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.data != right.data) {
            return false;
        }
        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }

    boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = null;
        root.right.left = new Node(2);
        root.right.right = null;
        SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();
        System.out.println(symmetricBinaryTree.isSymmetric(root));

    }
}
