package com.mahiznan.challenges;


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
//        printTree(n1);


//        String s = "1(2(4(8)(9))(5(10)(11)))(3(6(12)(13))(7(14)(15)))";
        String s = "1(2)(3)";
        char[] str = s.toCharArray();
        Tree t1 = new Tree(Integer.parseInt(String.valueOf(str[0])));
        constructTree(str, true, 1, t1);

    }

    private static void constructTree(char[] s, boolean isLeftTravel, int pos, Tree t) {

        //TODO: Tree construction is not working fine; Need to fix.
        printTree(t);

        if (pos == s.length) {
            printTree(t);
            return;
        }
        if (s[pos] == '(') {
            constructTree(s, true, pos + 1, t);
        }
        if (s[pos] == ')') {
            constructTree(s, false, pos + 1, t);
        }
        if (s[pos] != '(' && s[pos] != ')') {
            Tree child = new Tree(Integer.parseInt(String.valueOf(s[pos])));
            if (isLeftTravel) {
                t.setLeftChild(child);
            } else {
                t.setRightChild(child);
            }
        }
    }
}
