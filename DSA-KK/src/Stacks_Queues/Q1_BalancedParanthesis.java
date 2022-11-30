package Stacks_Queues;

// https://leetcode.com/problems/valid-parentheses/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q1_BalancedParanthesis {
    public static boolean isValid(String s) {
        ArrayList<Character> open = new ArrayList<>();
        open.add('(');
        open.add('{');
        open.add('[');
        ArrayList<Character> close = new ArrayList<>();
        close.add(')');
        close.add('}');
        close.add(']');
        Stack<Character> stack = new Stack<>();


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

        if (isValid(s))
            System.out.println("The parenthesis are BALANCED");
        else
            System.out.println("The parenthesis are NOT BALANCED");
    }
}
