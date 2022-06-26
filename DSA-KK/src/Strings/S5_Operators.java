package Strings;

import java.util.ArrayList;

// + operator is Overloaded in Java to support String Concatenation

public class S5_Operators {
    public static void main(String[] args) {

        // Character addition: Addition of the ASCII values of the char
        //                 97  +  98   =>  198
        System.out.println('a' + 'b');
        //                 97  -  98   =>  -1
        System.out.println('a' - 'b');

        // String addition: Concatenation of the strings
        System.out.println("a" + "b");
        // System.out.println("a" - "b"); --> No subtract operation possible

        // Char Addition and then conversion
        //                 (char) (97  + 3) = (char) 100 ==> 'd'
        System.out.println((char) ('a' + 3));

        // String Addition: Conversion of DataType -> toString() => String type
        // And further concatenation
        System.out.println("a" + 1);
        System.out.println("Indra" + new ArrayList<>(3));
        System.out.println("Indra" + new Integer(40));

        // + operator works with:
        //      1. Between all primitives
        //      2. Between any object/primitive and at least 1 String
        // System.out.println(new Integer(40) + new ArrayList<>()); ==> NOT Possible
        System.out.println(new Integer(40) + "" + new ArrayList<>());

    }
}
