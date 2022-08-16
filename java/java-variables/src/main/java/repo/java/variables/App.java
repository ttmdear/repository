package repo.java.variables;

public class App {
    public static void main(String[] args) {
        boolean input1 = true, input2 = false;  // Line 1
        boolean result1 = input1 = !input1; // Line 2
        boolean result2 = input2 = input1;  // Line 3
        boolean result3 = input1 == (result1=!input2);  // Line 4
        System.out.println(input1+" " +input2 + " " +  result2 + " " + result3);

        int a = 10;
        int b = 20;

        int c = a+++b;
        unsignedVariables();
//        narrowingAndWidening();
//        defineVariables();
    }

    private static void unsignedVariables() {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(Integer.toUnsignedString(a));
        a++;
        System.out.println(Integer.toUnsignedString(a));
    }

    private static void narrowingAndWidening() {
        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        char c = 'b';
        byte b1 = (byte) c;
        short s1 = (short) c;

        float f1 = c;
        double d1 = c;

        long l3 = Integer.MAX_VALUE; l3++;
        int i3 = (int) l3;

        System.out.println(l3);
        System.out.println(i3);
    }

    private static void defineVariables() {
        byte b = 127;
        byte b4 = 0b1111111;
        byte b5 = 'a';
        byte b6 = '\u007F';
        byte b7 = 0b0000_0001;

        char c = 127;
        char c5 = 'a';
        char c6 = '\u007F';
        char c7 = 0x0_07F;

        short s = 127;
        short s4 = 0177;  // octal 127 - octal prefix 0 only
        short s7 = 011_11;

        int i = 127;
        int i4 = 0x007F; // hexadecimal 127 - hex prefix 0x
        int i7 = 1_000_000;

        float f = 127;
        float f2 = 127f;
        float f3 = 127F;
        float f4 = 1.27e02f;
        float f7 = 1_000.000_000f;

        double d = 127;
        double d2 = 127d;
        double d3 = 127D;
        double d4 = 1.27e02;
        double d5 = 'a';
        double l7 = 1.000_0000e10;

        boolean isTrue = false;

        long l = 127;
        long l2 = 127l;
        long l3 = 127L;
        long d7 = 1_000_000L;

        // Wartość byte b9 = null, char c9 = null ... typy primitywne nie mogą być równe 0.
        // byte b8 = 0b_00000001;  // Cannot have underscore directly after 0b
        // char c8 = 0x_007F;  // Cannot have underscore directly after 0x
        // int i8 = 1000000_;  // Underscore cannot be at end of literal
        // long d8 = 1000000_L; // Underscore cannot be prior to suffix  (L/l,F/f,D/d)
        // float f8 = _1000.000000; // Underscore cannot be at start of literal
        // double l8 = 1.0000000_e10; // Underscore cannot prefix exponential in literal
    }

    private static boolean resolve() {
        return true;
    }
}
