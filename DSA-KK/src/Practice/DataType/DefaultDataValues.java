package DataType;

public class DefaultDataValues {
    boolean t;

    char c;

    byte b;

    short s;

    int i;

    long l;

    float f;

    double d;

    void print(String s) {
        System.out.println(s);
    }

    void printInitialValues() {
        print("Data type      Initial value");
        print("----------------------------");
        print("boolean        " + t);
        print("char           [" + c + "]");
        print("byte           " + b);
        print("short          " + s);
        print("int            " + i);
        print("long           " + l);
        print("float          " + f);
        print("double         " + d);
    }

    public static void main (String[] args) {
        DefaultDataValues dv = new DefaultDataValues();
        dv.printInitialValues();
    }
}
