package Arrays.Searching.BinaryS;

// Q 8 : Find the Smallest Letter Greater than target
// https://leetcode.com/problems/find-smallest-letter-greater-than-target

public class Q8_CharCeil {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j', 'k'};
        char target = 'l';

        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0, end = letters.length - 1, ceil = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                ceil = mid;
                end = mid - 1;
            }
            else // if (target >= letters[mid])
                start = mid + 1;
        }

        return letters[ceil % letters.length];
    }
}
