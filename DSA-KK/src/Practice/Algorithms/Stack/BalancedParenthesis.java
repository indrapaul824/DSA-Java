package Algorithms.Stack;

import java.util.*;
import java.util.Stack;

public class BalancedParenthesis {
    private final int MAX = 1000;
    private int top;
    private char[] arr = new char[MAX];

    BalancedParenthesis() {
        top = -1;
    }

    boolean isEmpty() {
        return top<0;
    }

    void push(char n) {
        if (top >= MAX-1) {
            System.out.println("Stack Overflow");
        }
        else {
            arr[++top] = n;
        }
    }

    char pop () {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return (char)top;
        }

        else
            return arr[top--];
    }

    int size() {
        return top+1;
    }

    char topElement() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return (char)top;
        }

        else
            return arr[top];
    }

    public static boolean balancedParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> open = new ArrayList<>();
        open.add('(');
        open.add('{');
        open.add('[');
        ArrayList<Character> close = new ArrayList<>();
        close.add(')');
        close.add('}');
        close.add(']');

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (open.contains(t))
                stack.push(t);
            else if (close.contains(t)) {
                if (stack.isEmpty())
                    return false;
                else if (open.indexOf(stack.peek()) == close.indexOf(t))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the parenthesis expression: ");
        String s = in.nextLine();

        if (balancedParenthesis(s))
            System.out.println("The parenthesis are BALANCED");
        else
            System.out.println("The parenthesis are NOT BALANCED");
    }
}
