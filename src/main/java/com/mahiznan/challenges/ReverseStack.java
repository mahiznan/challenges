package com.mahiznan.challenges;

import java.util.Stack;

public class ReverseStack {

    static Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.empty()) {
            newStack.push(stack.pop());
        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(6);
        System.out.println(stack);
        Stack<Integer> newStack = reverse(stack);
        System.out.println(newStack);
    }
}
