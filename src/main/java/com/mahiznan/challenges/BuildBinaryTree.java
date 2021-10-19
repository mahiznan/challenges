package com.mahiznan.challenges;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BuildBinaryTree {

    //Approach 1
    static boolean checkBST(Node root, Node left, Node right) {
        if (root == null)
            return true;
        if (left != null && root.data <= left.data)
            return false;
        if (right != null && root.data >= right.data)
            return false;
        return checkBST(root.left, left, root) && checkBST(root.right, root, right);
    }

    //Approach 2
    static boolean checkBST(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data <= minValue && root.data >= maxValue)
            return false;
        return checkBST(root.left, minValue, root.data) && checkBST(root.right, root.data, maxValue);
    }

    static boolean isValidBST(Node root) {
        return checkBST(root, null, null);
    }

    static boolean isValidBSTApproach2(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static Node buildTree(String s) {

        String[] nodeValues = s.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodeValues[0]));
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodeValues.length) {
            Node tNode = queue.poll();
            //Left Child
            String value = nodeValues[i];
            if (!Objects.equals(value, "N")) {
                Node leftChild = new Node(Integer.parseInt(value));
                queue.add(leftChild);
                tNode.left = leftChild;
            }
            i++;
            //Right Child
            value = nodeValues[i];
            if (!Objects.equals(value, "N")) {
                Node rightChild = new Node(Integer.parseInt(value));
                queue.add(rightChild);
                tNode.right = rightChild;
            }
            i++;
        }
        return root;
    }

    static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);

    }

    public static void main(String[] args) {
//        String s = "3 2 5 1 4";
        String s = "15 7 16 1 12 N N N 2 10 14";
        Node root = buildTree(s);
        //printInOrder(root);
        if (isValidBSTApproach2(root))
            System.out.println("Valid BST");
        else
            System.out.println("Invalid BST");
    }
}
