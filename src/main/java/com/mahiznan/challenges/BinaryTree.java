/*
You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root’s value and a pair of parenthesis contains a child binary tree with the same structure.

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


import java.util.Stack;

class Tree {
    private final int value;
    private Tree leftChild;
    private Tree rightChild;

    Tree(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Tree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Tree leftChild) {
        this.leftChild = leftChild;
    }

    public Tree getRightChild() {
        return rightChild;
    }

    public void setRightChild(Tree rightChild) {
        this.rightChild = rightChild;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }
}


public class BinaryTree {


    static void printTreeTest(Tree tree) {
        System.out.print(tree.getValue());
        if (tree.hasLeftChild()) {
            System.out.print("(");
            printTreeTest(tree.getLeftChild());
            System.out.print(")");
        }
        if (tree.hasRightChild()) {
            System.out.print("(");
            printTreeTest(tree.getRightChild());
            System.out.print(")");
        }

    }


    static void printTree(Tree tree) {
        System.out.print(tree.getValue());
        if (tree.hasLeftChild()) {
            System.out.print("(");
            printTree(tree.getLeftChild());
            System.out.print(")");
        }
        if (tree.hasRightChild()) {
            System.out.print("(");
            printTree(tree.getRightChild());
            System.out.print(")");
        }
    }


    public static void main(String[] args) {
        Tree n1 = new Tree(1);
        Tree n2 = new Tree(2);
        Tree n3 = new Tree(3);
        n1.setLeftChild(n2);
        n1.setRightChild(n3);
        Tree n4 = new Tree(4);
        Tree n5 = new Tree(5);
        n2.setLeftChild(n4);
        n2.setRightChild(n5);
        Tree n6 = new Tree(6);
        Tree n7 = new Tree(7);
        n3.setLeftChild(n6);
        n3.setRightChild(n7);

        Tree n8 = new Tree(8);
        Tree n9 = new Tree(9);
        n4.setLeftChild(n8);
        n4.setRightChild(n9);
        Tree n10 = new Tree(10);
        Tree n11 = new Tree(11);
        n5.setLeftChild(n10);
        n5.setRightChild(n11);
        Tree n12 = new Tree(12);
        Tree n13 = new Tree(13);
        n6.setLeftChild(n12);
        n6.setRightChild(n13);
        Tree n14 = new Tree(14);
        Tree n15 = new Tree(15);
        n7.setLeftChild(n14);
        n7.setRightChild(n15);
        printTreeTest(n1);
        System.out.println("");


        String s = "1(2(4(8)(9))(5(10)(11)))(3(6(12)(13))(7(14)(15)))";
//        String s = "1(2)(3)";
        Tree t = constructTree(s, 0, s.length() - 1);
        if (t != null) {
            printTreeTest(t);
            System.out.println("");
            printTree(t);
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

    private static Tree constructTree(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        int q = startIndex + 1;
        while (s.charAt(q) != '(' && s.charAt(q) != ')') {
            q++;
        }
        String v = s.substring(startIndex, q);
        System.out.println("V is " + v);
        Tree tree = new Tree(Integer.parseInt(v));
        int index = -1;
        if (startIndex + 1 <= endIndex && s.charAt(startIndex + 1) == '(') {
            index = findIndex(s, startIndex + 1, endIndex);
        }

        if (index != -1) {
            tree.setLeftChild(constructTree(s, startIndex + 2, index - 1));
            tree.setRightChild(constructTree(s, index + 2, endIndex - 1));
        }
        return tree;
    }
}
