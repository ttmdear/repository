package repo.java.string;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        construct();
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
