package com.mahiznan.faang;

/*
You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.

Input: nums = [3,2,1,6,0,5]
Output: [6,3,5,null,2,0,null,null,1]
Explanation: The recursive calls are as below:
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.

Refer the images MaximumBinaryTree-1.png & MaximumBinaryTree-2.png
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

public class MaximumBinaryTree {

    static int maxIndex(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    static TreeNode constructMaximumBinaryTree(int[] nums) {
        int index = maxIndex(nums, 0, nums.length - 1);
        TreeNode root = new TreeNode(nums[index]);
        constructTree(nums, 0, index - 1, root, true);
        constructTree(nums, index + 1, nums.length - 1, root, false);
        return root;
    }

    static void constructTree(int[] nums, int start, int end, TreeNode root, boolean isLeft) {
        int index = maxIndex(nums, start, end);
        if (index == -1) {
            return;
        }
        TreeNode node = new TreeNode(nums[index]);
        if (isLeft) {
            root.left = node;
        } else {
            root.right = node;
        }
        constructTree(nums, start, index - 1, node, true);
        constructTree(nums, index + 1, end, node, false);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode.val);

//        [6, 3, 5, null, 2, 0, null, null, 1]
    }
}
