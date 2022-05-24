package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class A6_ArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Synatx: ArrayList<data_type> var_name = new ArrayList<data_type>();
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(64);
        list.add(329);
        list.add(64);

        System.out.println(list);

        list.set(0, 99);
        System.out.println(list);

        list.remove(4);
        System.out.println(list);

        // INPUT: using for loop
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }

        /*
         PRINT: using for loop and .get() method
         ## list[index] will not work here
        */
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list);
    }
}
