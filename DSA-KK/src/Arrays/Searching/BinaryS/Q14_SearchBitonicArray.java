package Arrays.Searching.BinaryS;

public class Q14_SearchBitonicArray {

    interface MountainArray {
        public int get (int index);
        public int length();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 8, 4, 2};
        int target = 8;

        System.out.println("The target element is at: Index " + findInMountainArray(target, arr));
    }

    public static int findInMountainArray(int target, MountainArray mountainarr) {

    }
}
