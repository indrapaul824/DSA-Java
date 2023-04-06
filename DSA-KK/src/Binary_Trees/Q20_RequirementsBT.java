package Binary_Trees;

public class Q20_RequirementsBT {
    public static boolean isPossible(int a, int b){
        return (a == 2 && b != 2) || (a != 2 && b == 2);
    }
}
