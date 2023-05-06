package Leetcode;

public class ReverseInteger {
    public int reverse(int n) {
        if (n < 0)
            return -rev(-n);

        return rev(n);
    }

    public int rev(int x) {
        int rev = 0;
        int max = Integer.MAX_VALUE/10, min = Integer.MIN_VALUE/10;
        while(x != 0) {
            int r = x % 10;
            x /= 10;

            if (rev > max || rev == max && r > 7)
                return 0;

            if (rev < min || rev == min && r < -8)
                return 0;

            rev = rev*10 + r;
        }
        return rev;
    }
}
