package com.mahiznan.challenges;

// { Driver Code Starts
//Initial Template for Java
//TODO: Not working

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


class CheckForBST {

    static boolean checkBalanceTree(Node root, int v, boolean leftTravel) {
        if (root == null)
            return true;
        if ((leftTravel && root.data >= v) || (!leftTravel && root.data <= v))
            return false;
        if (checkBalanceTree(root.left, root.data, true))
            return checkBalanceTree(root.right, root.data, false);
        return false;
    }


    static boolean isBST(Node root) {
        if (root.left == null || root.right == null)
            return true;
        boolean res = false;
        if (root.data > root.left.data && root.data < root.right.data) {
            res = isBST(root.left);
            if (res)
                res = isBST(root.right);
        }
        return res;

    }

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
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
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            if (isBST(root))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }*/
//        String s = "2 7 6 5 9 2 6";
        String s = "2 N 7 N 6 N 5 N 9 N 2 N 6";
        Node root = buildTree(s);
        printInorder(root);
        if (isBST(root))
            System.out.println(1);
        else
            System.out.println(0);


    }

}


