package Recursion;

public class R1_Intro {
    public static void main(String[] args) {
        // Calls the print function which has a base condition
        print();
        // This recursion stack will complete once count == 3 and will not overload Stack Memory

        // Call function time only
        message();

        // This specific function will return the following Exception:
        // Exception in thread "main" java.lang.StackOverflowError
        //	at java.base/sun.nio.cs.UTF_8$Encoder.encodeLoop(UTF_8.java:564)
        //	at java.base/java.nio.charset.CharsetEncoder.encode(CharsetEncoder.java:585)
        //	at java.base/sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:301)
        //	at java.base/sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:290)
        //	at java.base/sun.nio.cs.StreamEncoder.write(StreamEncoder.java:131)
        //	at java.base/java.io.OutputStreamWriter.write(OutputStreamWriter.java:205)
        //	at java.base/java.io.BufferedWriter.flushBuffer(BufferedWriter.java:120)
        //	at java.base/java.io.PrintStream.writeln(PrintStream.java:722)
        //	at java.base/java.io.PrintStream.println(PrintStream.java:938)
        //	at Recursion.R1_Intro.message(R1_Intro.java:12)
        //	at Recursion.R1_Intro.message(R1_Intro.java:13)
        //	at Recursion.R1_Intro.message(R1_Intro.java:13)
        //	at Recursion.R1_Intro.message(R1_Intro.java:13)
    }

    static void message() {
        System.out.println(1);
        message();
    }

    static int count = 0;
    static void print() {
        if (count == 3)
            return;
        System.out.println(count);
        count++;
        print();
    }
}
