package com.mahiznan.challenges;


/*
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BinaryTreeMaker {


    private static TreeNode constructTree(char[] s, int pos, TreeNode t) {
        if (pos == s.length) {
            //BTree Constructed; return
            return t;
        }

        if (s[pos] == '(') {
            //Travel & build left tree
            t.left = new TreeNode(Character.getNumericValue(s[pos + 1]));
            constructTree(s, pos + 2, t.left);
        }

        t.right = new TreeNode(Character.getNumericValue(s[pos + 1]));

        // T[3]
        if (s[pos] == ')') {
            //Build Right child for my parent

        }
        return t;
    }


    //4(2(3)(1))(6(5)))


    public static void main(String[] args) {
        constructTree("4(2(3)(1))(6(5)))".toCharArray(), 0, new TreeNode(4));
        //(2(3)(1))(6(5)))
        TreeNode t = new TreeNode(4);
    }


}
