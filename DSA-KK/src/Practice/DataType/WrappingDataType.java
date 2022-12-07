package DataType;

// Wrapping a primitive type in a Wrapper Object

public class WrappingDataType {
    public static void main (String[] args) {
        Boolean refBoolean = Boolean.TRUE;
        boolean bool = refBoolean;

        Byte refByte = (byte) 123;
        byte b = refByte;

        Character refChar = 'x';
        char c = refChar;

        Short refShort = (short) 123;
        short s = refShort;

        Integer refInt = 123;
        int i = refInt;

        Long refLong = 123L;
        long l = refLong;


        Float refFloat = 12.3F;
        float f = refFloat;


        Double refDouble = 12.3D;
        double d = refDouble;
    }
}
