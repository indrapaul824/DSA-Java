package Arrays;

public class Q2_SortArray012 {
    public void sortColors(int[] nums) {
        int z = 0, o = 0, t = 0;
        for (int i : nums) {
            if (i == 0)
                z++;
            else if (i == 1)
                o++;
            else
                t++;
        }
        int i = 0;
        while (z-- > 0) {
            nums[i] = 0;
            i++;
        }
        while (o-- > 0) {
            nums[i] = 1;
            i++;
        }
        while (t-- > 0) {
            nums[i] = 2;
            i++;
        }
    }
}
