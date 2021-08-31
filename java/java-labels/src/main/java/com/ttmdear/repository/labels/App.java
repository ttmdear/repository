package com.ttmdear.repository.labels;

import java.util.Random;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class App {
    public static void main( String[] args ) {

        new App().run();
    }

    public void run() {
        runBreak();
    }

    private void runBreak() {

        loopX:
        for(int x = 0; x < 10; x++) {
            out.println(String.format("x -> %s", x));

            loopY:
            for(int y = 0; y < 10; y++) {
                out.println(String.format("y -> %s", y));

                if (x + y == 5) {
                    out.println(String.format("%s %s", x, y));

                    // Spowoduje, że przejdziemy do etykiety loopY i przetwarzać kolejne liczby
                    // continue loopY;

                    // Spowoduje, że przetwarzać do etykiety loopY, ale petla się zakończyła wiec
                    // program wykona się dalej, czyli przejdzie na x++
                    // break loopY;

                    // continue loopX;
                    // break loopX;
                }
            }
        }
    }
}
