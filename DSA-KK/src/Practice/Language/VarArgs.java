package Language;

// Using variable arguments and displaying all of them
// You can put any number of arguments and check this out

public class VarArgs {
    public void Var (int... args) {
        for (int arg : args) {
            System.out.println(arg);
        }
    }

    public static void main (String[] args) {
        VarArgs v = new VarArgs();
        v.Var(12, 13, 113);
        v.Var(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

}
