package com.mahiznan.challenges;// { Driver Code Starts
//Initial Template for Java

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class GfG {
    // String s = "2 1 2 2";
    // String s = "1 1 1 1 1 N 1 1 1 1 1";
    //String s = "3 2 5 1 4";
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
//        String s = "2 1 2 2";
        String s = "3 2 5 1 4";
//        String s = "15 7 16 1 12 N N N 2 10 14";
//        String s = "2 1 3";
        Node root = buildTree(s);
        BinarySearchTree g = new BinarySearchTree();
        if (g.isBST(root))
            System.out.println(1);
        else
            System.out.println(0);
    }
}

public class BinarySearchTree {
    static boolean isBST(Node root, Node l, Node r) {
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.data <= l.data)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.data >= r.data)
            return false;

        // check recursively for every node.
        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }

    boolean isBST(Node node) {
        return isBST(node, null, null);
    }


}
