package com.ttmdear.repository.keyfinal;

import java.util.function.Function;

public class App {

    public static void main( String[] args ) {
        Function<String, String> concat = getConcatFunction("2012_");

        System.out.println(concat.apply("report_płac"));

        //

        FinalThreadsTester finalThreadsTester = new FinalThreadsTester();
        finalThreadsTester.run();
    }

    public static Function<String, String> getConcatFunction(String prefix) {
        String s1 = prefix;

        Function<String, String> concat = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s1 + s;
            }
        };

        prefix = "new";

        return concat;
    }
}
