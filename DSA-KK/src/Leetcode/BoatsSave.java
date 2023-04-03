package Leetcode;
import java.util.*;

// https://leetcode.com/problems/boats-to-save-people/

public class BoatsSave {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length-1;
        int b = 0;

        while (i <= j) {
            b++;
            if (people[i] + people[j] <= limit) // mean 1 boat for both person
                i++;
            j--;
        }

        return b;
    }
}
