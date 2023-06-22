package Practice.Algorithms.SDOT;

public class NearestPrime {
    static boolean isPrime(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0) cnt++;
        return cnt == 2;
    }
    public static int nearestPrime(int num) {
        int leftPrime = num-1, rightPrime = num+1;
        while (!isPrime(leftPrime))
            leftPrime--;
        while (!isPrime(rightPrime))
            rightPrime++;

        if (num - leftPrime == rightPrime - num)
            return leftPrime;
        else if (num - leftPrime > rightPrime - num)
            return rightPrime;
        return leftPrime;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(nearestPrime(n));
    }
}
