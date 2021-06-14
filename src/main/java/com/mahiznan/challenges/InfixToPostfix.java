package com.mahiznan.challenges;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {


    public static String infixToPostfix(String exp) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        String ops = "-+/*^()";
        for (int i = 0; i < exp.length(); ++i) {
            System.out.println("Iteration " + (i + 1));
            String currentCharacter = String.valueOf(exp.charAt(i));
            System.out.println("Checking for " + currentCharacter);
            String p = stack.isEmpty() ? "" : stack.peek();
            int a = prec(currentCharacter), b = prec(p);
            System.out.println("P => " + p);
            System.out.println("a => " + a);
            System.out.println("b => " + b);
            if (!ops.contains(currentCharacter)) {
                System.out.println("It is not operator; So adding " + currentCharacter + " to result " + result);
                result.append(currentCharacter);
                System.out.println("Result is ----> " + result);
            } else if (currentCharacter.equals("(") || a > b) {
                if (currentCharacter.equals("(")) {
                    System.out.println("Open brace");
                } else {
                    System.out.println("Current operator [" + currentCharacter + "] is greater than previous operator [" + p + "]");
                }
                stack.push(currentCharacter);
                System.out.println(stack);
            } else if (currentCharacter.equals(")")) {
                System.out.println("Close brace");
                while (!stack.peek().equals("(")) result.append(stack.pop());
                System.out.println(stack);
                stack.pop();
                System.out.println(stack);
            } else {
                System.out.println("Else Condition");
                System.out.println("P => " + p);
                System.out.println("a => " + a);
                System.out.println("b => " + b);
                while (!p.equals("(") && a <= b) {
                    System.out.println("Entry Result is ----> " + result);
                    System.out.println(stack);
                    result.append(stack.pop());
                    p = stack.isEmpty() ? "" : stack.peek();
                    b = prec(p);
                    System.out.println("Exit Result is ----> " + result);
                }
                stack.push(currentCharacter);
                System.out.println(stack);
            }
            System.out.println("------------------------");
            System.out.println("");
        }
        System.out.println("After Loop Result " + result);
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    public static int prec(String s) {
        int i;
        switch (s) {
            case "^":
                i = 4;
                break;
            case "*":
            case "/":
                i = 3;
                break;
            case "+":
            case "-":
                i = 1;
                break;
            default:
                i = 0;
        }
        return i;
    }

    public static void main(String[] args) {
//        String exp = "A*(B+C)/D";
//        String exp = "A+B*C";
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
