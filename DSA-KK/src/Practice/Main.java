package Practice;

import java.util.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int t = 1;

        while (t-- > 0) {
            int a = 2, b = 5;
            int div = 1;
            for (int i = 1; i <= Math.max(a, b); i++) {
                if (a%i != 0 || b%i != 0) {
                    div = i - 1;
                    break;
                }
            }
            System.out.println(div);
        }
    }
}
