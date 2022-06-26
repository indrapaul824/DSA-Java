package Strings;

public class S6_Performance {
    public static void main(String[] args) {
        String series = "";

        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            System.out.print(ch + " ");
            series += ch;
        }

        // The concatenation inside the for-loop creates a new object at every iteration.
        // This leads to O(N^2) Space Complexity since all the string objects
        // created prior to the last iteration will be stored in memory but
        // won't be referenced causing Memory Wastage

        System.out.println(series);
    }
}
