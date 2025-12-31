package com.mahiznan.faang;

/*
Given a binary tree, return its maximum depth.

The depth of a binary tree is the number of nodes from the root node to any of the leaf nodes. The maximum depth is the maximum of the depths across all the paths.

Example
binary-tree-depth
Testing
Input Format
The first line contains an integer T denoting the number of test cases.

For each test case, the input has 2 lines:

The first line contains an integer n denoting the number of nodes in the tree (including the NULL nodes).
The second line contains n space-separated integers that will form the binary tree. The integers follow level order traversal of the tree where -1 indicates a NULL node.
Output Format
For each test case, the output has an integer denoting the maximum depth of the tree.

Sample Input
5
12
1 2 3 4 5 6 -1 -1 -1 7 -1 8
7
1 2 -1 4 -1 5 6
7
8 -1 9 -1 10 11 12
5
28 14 11 -1 48
1
6
Expected Output
4
4
4
3
1
Constraints
1 <= T <= 10
1 <= n <= 105
1 <= node value <= 104
 */
public class MaximumDepthOfBinaryTree {
    static class Node {
        public Node left;
        public Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    int depth(Node root) {
        if (root == null) return 0;

    }

    int getMaxDepth(Node root) {
        return 0;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maxDepth = new MaximumDepthOfBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(maxDepth.getMaxDepth(root));
    }
}
