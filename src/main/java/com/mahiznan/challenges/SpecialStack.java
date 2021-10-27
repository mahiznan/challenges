package com.mahiznan.challenges;

import java.util.Stack;


class SpecialStackWithNoExtraMemory {
    Stack<Integer> stack = new Stack<>();
    int d = 9999, min;

    void push(int i) {
        if (stack.isEmpty()) {
            min = i;
        }
        int v = i * d + min;
        stack.push(v);
    }

    int pop() {
        int v = stack.pop();
        min = stack.peek() % d;
        return v / d;
    }

    int min() {
        return min;
    }

}


public class SpecialStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(2);
        s.push(9);
        s.push(4);
        s.push(3);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());


        SpecialStackWithNoExtraMemory s2 = new SpecialStackWithNoExtraMemory();
        s2.push(3);
        s2.push(9);
        s2.push(4);
        s2.push(2);
        s2.push(1);
        System.out.println(s2.min());
        System.out.println(s2.pop());
        System.out.println(s2.min());
        System.out.println(s2.pop());
        System.out.println(s2.min());
    }

    void push(int i) {
        s1.push(i);
        if (s2.isEmpty()) {
            s2.push(i);
        } else {
            s2.push(Math.min(s2.peek(), i));
        }
    }

    int pop() {
        s2.pop();
        return s1.pop();
    }

    int peek() {
        return s1.peek();
    }

    int getMin() {
        return s2.peek();
    }

}
