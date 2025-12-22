package com.mahiznan.faang;

import java.util.Stack;

public class LargestRectangleInHistogram {

    int getLargestArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    void main(String[] args) {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        int[] heights = {8, 2, 10, 12, 7, 0, 10, 8};

        System.out.println(obj.getLargestArea(heights));
    }
}
