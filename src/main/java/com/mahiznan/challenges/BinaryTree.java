/*
You need to construct a binary node from a string consisting of parenthesis and integers.

The whole input represents a binary node. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root’s value and a pair of parenthesis contains a child binary node with the same structure.

You always start to construct the left child node of the parent first if it exists.

Input: s = "4(2(3)(1))(6(5))"
Output:
     4
   /    \
  2      6
 / \    /
3   1   5
*/

package com.mahiznan.challenges;


import com.mahiznan.util.Node;

import java.util.Stack;


public class BinaryTree {
    static void printNodeTest(Node node) {
        System.out.print(node.data);
        if (node.left != null) {
            System.out.print("(");
            printNodeTest(node.left);
            System.out.print(")");
        }
        if (node.right != null) {
            System.out.print("(");
            printNodeTest(node.right);
            System.out.print(")");
        }

    }


    static void printNode(Node node) {
        System.out.print(node.data);
        if (node.left != null) {
            System.out.print("(");
            printNode(node.left);
            System.out.print(")");
        }
        if (node.right != null) {
            System.out.print("(");
            printNode(node.right);
            System.out.print(")");
        }
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n2.left = n4;
        n2.right = n5;
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n3.left = n6;
        n3.right = n7;

        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n4.left = n8;
        n4.right = n9;
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        n5.left = n10;
        n5.right = n11;
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        n6.left = n12;
        n6.right = n13;
        Node n14 = new Node(14);
        Node n15 = new Node(15);
        n7.left = n14;
        n7.right = n15;
        printNodeTest(n1);
        System.out.println();


        String s = "1(2(4(8)(9))(5(10)(11)))(3(6(12)(13))(7(14)(15)))";
//        String s = "1(2)(3)";
        Node t = constructNode(s, 0, s.length() - 1);
        if (t != null) {
            printNodeTest(t);
            System.out.println();
            printNode(t);
        }

    }

    private static int findIndex(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return -1;

        Stack<Character> stack = new Stack<>();
        for (int i = startIndex; i <= endIndex; i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty())
                    return i;
            }
        }
        return -1;
    }

    private static Node constructNode(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        //Extract the value
        int q = startIndex + 1;
        while (s.charAt(q) != '(' && s.charAt(q) != ')') {
            q++;
        }
        String value = s.substring(startIndex, q);
        System.out.println("V is " + value);
        Node node = new Node(Integer.parseInt(value));
        int index = -1;
        if (startIndex + 1 <= endIndex && s.charAt(startIndex + 1) == '(') {
            index = findIndex(s, startIndex + 1, endIndex);
            System.out.println("Index value is " + index);
        }

        if (index != -1) {
            node.left = constructNode(s, startIndex + 2, index - 1);
            node.right = constructNode(s, index + 2, endIndex - 1);
        }
        return node;
    }
}
