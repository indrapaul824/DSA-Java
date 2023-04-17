package Practice.Algorithms.SDOT;
import utils.Main.*;

public class MaxFitness {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int[] t1 = new int[3], t2 = new int[3], t3 = new int[3];
        int[] avg = new int[3];
        System.out.println("Enter the O2 levels:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Round " + (i+1) + ": ");
            t1[i] = in.nextInt();
            while (t1[i] < 0 || t1[i] > 100) {
                System.out.println("Invalid Input -> Enter Again: ");
                t1[i] = in.nextInt();
            }
            avg[0] += t1[i];
            t2[i] = in.nextInt();
            while (t2[i] < 0 || t2[i] > 100) {
                System.out.println("Invalid Input -> Enter Again: ");
                t2[i] = in.nextInt();
            }
            avg[1] += t2[i];
            t3[i] = in.nextInt();
            while (t3[i] < 0 || t3[i] > 100) {
                System.out.println("Invalid Input -> Enter Again: ");
                t3[i] = in.nextInt();
            }
            avg[2] += t3[i];
        }

        int max = Integer.MIN_VALUE;
        for (int a : avg) {
            a /= 3;
        }
//
//        int max = Math.max(avg1, Math.max(avg2, avg3));
//
//        if (max < 70)
//            System.out.println("All trainees are Unfit!");
//        else {
//            if (max == avg1 && max == avg2 && max == avg3)
//                System.out.println("Trainee 1, 2 and 3");
//            else if (max == avg1 && max == avg2)
//                System.out.println("Trainee 1 and 2");
//            else if (max == avg1 && max == avg3)
//                System.out.println("Trainee 1 and 3");
//            else if (max == avg2 && max == avg3)
//                System.out.println("Trainee 2 and 3");
//            else {
//                if (max == avg1)
//                    System.out.println("Trainee 1");
//                else if (max == avg2)
//                    System.out.println("Trainee 2!");
//                else
//                    System.out.println("Trainee 3");
//            }
//        }
    }
}
