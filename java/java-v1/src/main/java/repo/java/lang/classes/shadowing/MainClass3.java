package repo.java.lang.classes.shadowing;

import repo.java.arrays.Main;

public class MainClass3 {
    private static String STATIC_VAR = "MainClass2";
    private String fieldVar = "MainClass2";

    public class NestedClass {
        private static String STATIC_VAR = "NestedClass";
        private String fieldVar = "NestedClass";

        public void doSth() {
            String STATIC_VAR = "doSth";
            String fieldVar = "doSth";

            System.out.printf("%s - %s - %s%n", STATIC_VAR, NestedClass.STATIC_VAR, MainClass3.STATIC_VAR);
            System.out.printf("%s - %s - %s%n", fieldVar, this.fieldVar, MainClass3.this.fieldVar);
        }
    }
}
