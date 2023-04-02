package Leetcode;
import java.util.*;

public class SuccessfulSpellsPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        int n = potions.length;
        for (int i = 0; i < spells.length; i++) {
            int low = 0;
            int high = n;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if ((long)potions[mid] * spells[i] >= success)
                    high = mid;
                else
                    low = mid + 1;
            }
            res[i] = n - low;
        }
        return res;
    }
}
