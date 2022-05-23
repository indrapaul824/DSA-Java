package Arrays;

public class Main {
    public static void main(String[] args) {
        // syntax: data_type[] var_name = new data_type[size];
        int[] rnos = new int[5];
        // OR
        int[] rnos2 = {12, 23, 48, 89, 64};
        
        System.out.println(rnos[1]); // Returns 0 -> Initialized to 0 since no value mentioned

        System.out.println(rnos2[2]); // Returns 48 -> Initailized object in heap to value 48

        String[] arr = new String[4];
        System.out.println(arr[2]);
    }
}
