package repo.java.variables;

import org.w3c.dom.html.HTMLOListElement;

import java.util.Arrays;

public class App {
    // var int age = 10;

    public static void main(String[] args) {
        typeInference();
        scope(1, '3');
        unicode();
        binaryAndHexNotation();
        unsignedVariables();
        narrowingAndWidening();
        defineVariables();
    }

    private static void typeInference() {
        printHead("typeInference");
//        var userName = null;

        int a = 10;
        var b = a;

        var scopeClass = getScopeClass();

        for(var c = b; c <= 10; c++) {
            // ...
        }

        // var x, y, x = 10;

        var user = new ScopeClass(1, 2);
        user = null;
        var aga = user;

        class Var {
            private int var = 10;

            public Var(int var) {
                this.var = var;

                var b = var;
            }
        }

        printEnd();
    }

    private static void printEnd() {
        System.out.println("--------------------------------------------");
    }

    private static void scope(int var1, char var2) {
        // Local scope
        var1 = 10;

        if (var1 >= 10) {
            int var3 = 20;
        }

        // Lambda scope
        int finalVar = var1;

        Arrays.asList("1", "2").forEach(s -> {
            printf("%s - %s", finalVar, s);
        });

        for (int var3 = 0; var3 < 10; var3++) {
            // loop scope
            printf("%s%n", var3);
        }

        while (var1 < 100) {
            // loop scope
            int var4 = 10;
            // ...
            var1++;
        }

        var2 = 20;

        class LocalClass {
            private int var1;

            public LocalClass() {
                this.var1 = var1;
            }

            public void test() {
                System.out.println("LocalClass.var1 " + var1);
                // System.out.println("LocalClass.var2 " + var2); // var is not final
            }
        }

        new LocalClass().test();
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    private static void unicode() {
        printHead("unicode");

        char c = '\u0987';

        System.out.println(c);
    }

    private static void binaryAndHexNotation() {
        printHead("binaryAndHexNotation");
        byte b = 0b100;
        short s = 0b100;
        int i = 0b100;
        long l = 0b100;
        float f = 0b100;

        System.out.printf("byte %s%n", b);
        System.out.printf("short %s%n", s);
        System.out.printf("int %s%n", i);
        System.out.printf("long %s%n", l);
        System.out.printf("float %s%n", f);

        byte bh = 0x4;
        System.out.printf("byte %s%n", bh);
    }

    private static void printHead(String title) {
        System.out.println(title);
        System.out.println("--------------------------------------------");
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

        long l3 = Integer.MAX_VALUE;
        l3++;
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

    private static ScopeClass getScopeClass() {
        return new ScopeClass(1, 2);
    }

    static class ScopeClass {
        // Przestrzeń klasy
        private static int var1;
        private int var2;

        public ScopeClass(int var1, int var2) {
            ScopeClass.var1 = 1;
            this.var2 = 2;
            var1 = 3;
            var2 = 4;

            Arrays.asList("1", "2").forEach(s -> {
                // Przetrzeń lambda
                printf("%s - %s", this.var2, s);
            });
        }
    }
}
