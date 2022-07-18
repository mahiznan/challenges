package common;

import java.util.LinkedList;
import java.util.Queue;

public class Util {
    // String s = "2 1 2 2";
    // String s = "1 1 1 1 1 N 1 1 1 1 1";
    //String s = "3 2 5 1 4";
    public static BinaryTreeNode buildBinaryTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        // Create the root of the tree
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            BinaryTreeNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new BinaryTreeNode(Integer.parseInt(currVal));
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
                currNode.right = new BinaryTreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
}
