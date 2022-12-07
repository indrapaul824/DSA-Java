package Language;

public class GarbageCollection {
    public static void main (String[] args) {

        // Run object finalization using System class
        System.runFinalization();

        // Run the garbage collector using System class
        System.gc();
    }
}
