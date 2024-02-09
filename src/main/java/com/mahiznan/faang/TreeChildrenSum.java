package com.mahiznan.faang;

import com.mahiznan.util.Node;
import com.mahiznan.util.Util;

/*

Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.

Example 1:

Input:
Binary tree
       35
      /   \
     20  15
    /  \  /  \
   15 5 10 5
Output:
1
Explanation:
Here, every node is sum of its left and right child.
Example 2:

Input:
Binary tree
       1
     /   \
    4    3
   /
  5
Output:
0
Explanation:
Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isSumProperty() that takes the root Node of the binary tree as input and returns 1 if all the nodes in the tree satisfy the following properties, else it returns 0.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 105
1 <= Data on nodes <= 105

 */
public class TreeChildrenSum {

    public static boolean isValid(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        if (node.left == null) {
            return node.data == node.right.data && isValid(node.right);
        }
        if (node.right == null) {
            return node.data == node.left.data && isValid(node.left);
        }

        return (node.data == node.left.data + node.right.data)
                && isValid(node.left)
                && isValid(node.right);
    }


    public static int isSumProperty(Node root) {
        if (isValid(root)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        /*Node node1 = new Node(35);
        Node node2 = new Node(20);
        Node node3 = new Node(15);
        Node node4 = new Node(15);
        Node node5 = new Node(5);
        Node node6 = new Node(10);
        Node node7 = new Node(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;*/

        /*Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;*/

//        1 N 1 N 1 N 3
        String tree = "1 N 1 N 1 N 3";
        Node root = Util.buildBinaryTree(tree);
        System.out.println(isSumProperty(root));
    }
}
