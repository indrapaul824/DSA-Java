package Leetcode;

public class ParkingSystem {
    int[] m;

    public ParkingSystem(int big, int medium, int small) {
        m = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return m[carType - 1]-- > 0;
    }
}
