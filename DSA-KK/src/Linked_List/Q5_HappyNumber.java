package Linked_List;

public class Q5_HappyNumber {

    public static int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }

        return ans;
    }


    public static boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != slow);

        return slow == 1;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Is it a Happy Number? - " + isHappy(n));
    }
}
