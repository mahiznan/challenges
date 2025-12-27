package com.mahiznan.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its elements.

Testing
Input Format
The first line contains an integer T denoting the number of test cases.

For each test case, the input has 2 lines:

The first line contains an integer n denoting the number of nodes in the tree (including the NULL nodes).
The second line contains n space-separated integers that will form the binary tree. The integers follow level order traversal of the tree where -1 indicates a NULL node.
Output Format
For each test case, the output has a line containing the inorder traversal of the tree.

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
4 2 7 5 1 8 6 3
5 4 6 2 1
8 9 11 10 12
14 48 28 11
6
Constraints
1 <= T <= 10
1 <= n <= 105
1 <= node value <= 104
 */
public class BinaryTreeInorderTraversal {

    static class Node {
        public Node left;
        public Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    void inorder(Node root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    List<Integer> getInorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }


    List<Integer> getInorderTraversal_Stack(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.data);
            root = root.right;
        }

        return res;
    }

    List<Integer> getInorderTraversal_Optimal(Node root) {
        List<Integer> nodes = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    nodes.add(cur.data);
                    cur = cur.right;
                }
            } else {
                nodes.add(cur.data);
                cur = cur.right;
            }
        }
        return nodes;
    }

    List<Integer> getInorderTraversal_Timelimit_Exceeds(Node root) {
        List<Integer> result = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.data);
                curr = curr.right;
            } else {
                Node prev = curr.left;

                // Find the rightmost node in left subtree
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    // Make thread
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // Remove thread
                    prev.right = null;
                    result.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
