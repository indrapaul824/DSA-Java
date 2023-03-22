package Practice.Algorithms;

import java.util.Stack;

public class BackSpaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder S = new StringBuilder(s);
        StringBuilder T = new StringBuilder(t);

        while(S.indexOf("#") > -1) {
            if (S.indexOf("#") == 0) {
                S.replace(0,1, "");
                continue;
            }

            S.replace(S.indexOf("#")-1, S.indexOf("#")+1, "");
        }

        while(T.indexOf("#") > -1) {
            if (T.indexOf("#") == 0) {
                T.replace(0,1, "");
                continue;
            }
            T.replace(T.indexOf("#")-1, T.indexOf("#")+1, "");
        }

        return S.toString().equals(T.toString());
    }

    public static boolean backSpaceComp(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(!st1.isEmpty() && s.charAt(i) == '#') st1.pop();
            else if(s.charAt(i)!='#') st1.push(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(!st2.isEmpty() && t.charAt(i) == '#') st2.pop();
            else if(t.charAt(i)!='#') st2.push(t.charAt(i));
        }
        return st1.equals(st2);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backSpaceComp("a##c", "#a#c"));
    }
}
