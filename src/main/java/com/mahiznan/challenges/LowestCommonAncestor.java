package com.mahiznan.challenges;

import com.mahiznan.util.Node;

import java.util.Scanner;

public class LowestCommonAncestor {
    public static Node lca(Node root, int v1, int v2) {
        if (root.data > v1 && root.data > v2)
            return lca(root.left, v1, v2);
        if (root.data < v1 && root.data < v2)
            return lca(root.right, v1, v2);
        return root;
    }

    public static Node lcaPractice(Node node, int v1, int v2) {
        if (node.data > v1 && node.data > v2)
            return lca(node.left, v1, v2);
        if (node.data < v1 && node.data < v2)
            return lca(node.right, v1, v2);
        return node;
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}

/*
7
5 3 8 2 4 6 7
7 3
 */

