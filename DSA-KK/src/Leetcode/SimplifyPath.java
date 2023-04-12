package Leetcode;
import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        var st = new ArrayDeque<String>();

        String[] p = path.split("/");

        for (String s : p) {
            if (!st.isEmpty() && s.equals(".."))
                st.pop();
            else if (!s.equals("") && !s.equals(".") && !s.equals(".."))
                st.push(s);
        }

        if (st.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!st.isEmpty())
            sb.append(st.pollLast()).append("/");
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
