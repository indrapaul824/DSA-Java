package Practice.Algorithms.TCS_Training;

import utils.Main.*;
import java.util.*;

public class BalancedParenthesis {
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
        FastReader in = new FastReader();
        System.out.println("Enter the parenthesis expression: ");
        String s = in.nextLine();

        if (balancedParenthesis(s))
            System.out.println("The parenthesis are BALANCED");
        else
            System.out.println("The parenthesis are NOT BALANCED");
    }
}
