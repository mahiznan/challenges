package com.mahiznan.faang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
A perfect binary tree is a binary tree in which all interior nodes have two children and all leaves have the same depth or same level.

Given a perfect binary tree which contains an extra next pointer in all the node, populate the next pointers of each node to its next right node.

In nodes with no right nodes, set next to null.

Testing
Input Format
The first line contains an integer T denoting the number of test cases.

For each test case, the input has 2 lines:

The first line contains an integer n denoting the number of nodes in the tree.
The second line contains n space-separated integers that will form the binary tree. The integers follow level order traversal of the tree.
Output Format
For each test case, the output has two lines:

The first line contains the number of nodes in the tree.
The second line contains space-separated integers denoting the level order traversal of the tree done using the next pointer for each level.
Sample Input
4
1
1
3
1 3 2
7
3 5 6 1 2 7 4
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
Expected Output
1
1
3
1 3 2
7
3 5 6 1 2 7 4
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
Constraints
1 <= T <= 10
1 <= n <= 105
1 <= node value <= 104
 */
public class PopulatingNextRightPointersInEachNode {
    static class Node {
        public Node left;
        public Node right;
        public Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    void connect(Node root) {
        Queue<Node> firstQueue = new LinkedList<>();
        Queue<Node> secondQueue = new LinkedList<>();
        firstQueue.add(root);
        while (!firstQueue.isEmpty()) {
            updateRightPointer(firstQueue, secondQueue);
            updateRightPointer(secondQueue, firstQueue);
        }
    }

    private void updateRightPointer(Queue<Node> firstQueue, Queue<Node> secondQueue) {
        Node currentNode;
        while (!firstQueue.isEmpty()) {
            currentNode = firstQueue.poll();
            if (currentNode.left != null) {
                secondQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                secondQueue.add(currentNode.right);
            }
            if (!firstQueue.isEmpty()) {
                currentNode.next = firstQueue.peek();
            }
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        PopulatingNextRightPointersInEachNode node = new PopulatingNextRightPointersInEachNode();
        node.connect(one);
        System.out.println("Done");
    }
}
