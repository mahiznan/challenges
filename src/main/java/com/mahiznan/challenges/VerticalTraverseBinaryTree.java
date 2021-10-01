package com.mahiznan.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

//For some large test case below solution failed.
public class VerticalTraverseBinaryTree {

    static Node buildTree(String str) {
        //3 1 5 N 2 4 7 N N N N 6
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int t = Integer.parseInt(br.readLine());

//        while (t-- > 0) {
        String s = "3 1 5 N 2 4 7 N N N N 6";
//        String s = "1 2 3 4 5 6 7 N N N N N 8 N 9";
        //Expected Output
        //4 2 1 5 6 3 8 7 9
        Node root = buildTree(s);
        printInorder(root);
        Map<Integer, ArrayList<Integer>> sortedMap = new TreeMap<>();
        Map<Integer, ArrayList<Integer>> res = verticalOrder(root, sortedMap, 0);
        ArrayList<Integer> finalResult = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : res.entrySet()) {
            finalResult.addAll(entry.getValue());
        }
        System.out.println(finalResult);
//        }
    }

    static Map<Integer, ArrayList<Integer>> verticalOrder(Node root, Map<Integer, ArrayList<Integer>> map, int level) {
        ArrayList<Integer> cu = map.get(level);
        if (cu == null) {
            cu = new ArrayList<>();
            cu.add(root.data);
        } else {
            cu.add(root.data);
        }
        map.put(level, cu);
        if (root.left != null)
            verticalOrder(root.left, map, level - 1);
        if (root.right != null)
            verticalOrder(root.right, map, level + 1);
        return map;
    }
}


