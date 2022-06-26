package Strings;

public class S7_StringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            builder.append(ch);
        }

        // StringBuilder DataType --> Mutable Strings for optimized performance

        System.out.println(builder);
    }
}
