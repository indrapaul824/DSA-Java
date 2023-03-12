package Practice.Algorithms.TCS_Training;
import utils.Main.*;
public class ToggleBulbs {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(bulbSwitch(n));
    }

    public static int bulbSwitch(int n) {
        if (n <= 1) return n;
        return (int)Math.sqrt(n);
    }
}
