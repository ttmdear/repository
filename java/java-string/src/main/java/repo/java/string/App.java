package repo.java.string;

import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
//        construct();
//        intern();
//        immutable();
//        concating();
//        comparison();
        search();
    }

    private static void search() {
        String s1 = "xwordywordzword";
        //           012345678901234

        int i1 = s1.indexOf("word");
        int i2 = s1.lastIndexOf("word");
        int i3 = s1.lastIndexOf("game");

        System.out.printf("i1 -> %s%n", i1); // 1
        System.out.printf("i2 -> %s%n", i2); // 11
        System.out.printf("i2 -> %s%n", i3); // -1

        Pattern pattern = Pattern.compile(".*y.*");
        System.out.printf("match -> %s%n", pattern.matcher(s1).matches()); // match -> true


        boolean reg = s1.regionMatches(5, "yword", 0, 5);
        System.out.printf("reg -> %s%n", reg);
    }

    private static void concating() {
        String s1 = "User";
        String s2 = s1 + " 2";

        System.out.printf("s2 %s%n", s2);

        String s3 = s1.concat(s2);

        System.out.printf("s3 %s%n", s3);

        String s4 = "Person";
        s4 += s3;

        System.out.printf("s4 %s%n", s4);
    }

    private static void comparison() {
        String s1 = new String(new char[]{'J', 'O', 'H', 'N'});
        String s2 = new String("JPHN");

        int c1 = s1.compareTo(s2);

        System.out.printf("c1 %s%n", c1); // 1
    }

    private static void immutable() {
        String s1 = "User 1" + "User 2" + "User 3";
        System.out.printf("s1 %s%n", s1);
    }

    private static void intern() {
        String s1 = "TEST";
        String s2 = "TEST";

        System.out.printf("s1 == s2: %s%n", s1 == s2);

        String s3 = new String("TEST");
        String s4 = new String("TEST");

        System.out.printf("s3 == s4: %s%n", s3 == s4);

        String s5 = s3.intern();
        String s6 = s4.intern();

        System.out.printf("s5 == s6: %s%n", s5 == s6);

        String s7 = new String().intern();
        String s8 = new String();

        System.out.printf("s7 == s8: %s%n", s7 == s8);
    }

    private static void construct() {
        String original = new String("John");

        String charArray = new String(new char[]{'1', '2', '3', '4', '5', '6', '7'});
        String charArray2 = new String(new char[]{'1', '2', '3', '4', '5', '6', '7'}, 1, 3);

        System.out.printf("original: %s%n", original);
        System.out.printf("charArray: %s%n", charArray);
        System.out.printf("charArray2: %s%n", charArray2);

        String bytes = new String(new byte[]{0b01010000, 0b01000001, 0x57, 0x45, (byte) 0b11000101, (byte) 0b10000001});
        System.out.printf("bytes: %s%n", bytes);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PAWEŁ");
        String builder = new String(stringBuilder);
        System.out.printf("builder: %s%n", builder);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PAWEŁ");
        String buffer = new String(stringBuffer);
        System.out.printf("buffer: %s%n", buffer);


        String char1Array = new String(new char[]{'1', '2'});
        String char2Array = new String(new byte[]{(byte) 0b00110001, (byte) 0b00110010});
        System.out.printf("char1Array: %s, char2Array: %s%n", char1Array, char2Array);
        System.out.printf("char1Size: %s, char2Size: %s %n", char1Array.getBytes().length, char2Array.getBytes().length);
    }

    private static String binary(byte bytes[]) {
        var builder = new StringBuilder();

        for (int by = 0; by < bytes.length; by++) {
            for(int b = 7; b >= 0; b--) {
                if ((bytes[by] & (1 << b)) > 0) {
                    builder.append("1");
                } else {
                    builder.append("0");
                }
            }

            builder.append(" ");
        }

        return builder.toString();
    }
}
