package com.mahiznan.challenges;

import common.BinaryTreeNode;
import common.Util;

/*
 * Given a BST and a number X, find ceil of X in the binary tree.
 *
 * Example 1:
 *
 *      5
 *    /  \
 *  1    7
 *   \
 *    2
 *     \
 *      3
 *
 * X = 3, Output = 3. We find 3 in the BST, so ceil of 3 is 3
 *
 * Example 2:
 *
 *
 * */
public class CeilInBST {
    static int findCeil(BinaryTreeNode root, int key) {
        int ceil = -1, t;
        if (root == null) return ceil;
        if (root.data == key)
            return key;
        if (root.data > key) {
            ceil = root.data;
            t = findCeil(root.left, key);
        } else
            t = findCeil(root.right, key);
        if (t != -1 && (ceil == -1 || ceil > t))
            ceil = t;
        return ceil;
    }

    public static void main(String[] args) {
//        String tree = "5 1 7 N 2 N N N 3";
//        int key = 3;
//        String tree = "10 5 11 4 7 N N N N N 8";
//        int key = 6;
        String tree = "7 1 9 N 4 8 10";
        int key = 2;
        BinaryTreeNode root = Util.buildBinaryTree(tree);
        System.out.println(findCeil(root, key));
    }
}
