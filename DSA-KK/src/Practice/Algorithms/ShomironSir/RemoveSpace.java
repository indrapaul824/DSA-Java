package Practice.Algorithms.ShomironSir;
import utils.Main.*;
public class RemoveSpace {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) == ' '))
                sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
