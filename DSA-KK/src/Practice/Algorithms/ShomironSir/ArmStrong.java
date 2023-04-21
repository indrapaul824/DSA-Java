package Practice.Algorithms.ShomironSir;
import utils.Main.*;
public class ArmStrong {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int low = (int)Math.pow(10, n-1);
        int high = low * 10;
        for (int i = low; i < high; i++) {
            if (isArm(i))
                System.out.println(i);
        }
    }
    public static boolean isArm(int n) {
        int m = n, len = 0;
        while (m > 0) {
            len++;
            m /= 10;
        }
        int arm = 0;
        m = n;
        while (m > 0) {
            int r = m % 10;
            arm = arm + (int)Math.pow(r, len);
            m /= 10;
        }
        return n == arm;
    }
}
