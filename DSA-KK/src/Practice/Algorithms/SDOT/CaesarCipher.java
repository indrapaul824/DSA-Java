package Practice.Algorithms.SDOT;
import utils.Main.*;

public class CaesarCipher {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String s = in.nextLine();
        int key = in.nextInt();
        System.out.println(encrypt(s, key));
    }

    private static String encrypt(String s, int key) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '-' || c == ' ')
                sb.append(c);
            else
                sb.append((char) ((c + key) % 256));
        }

        return sb.toString();
    }
}
