package repo.java.basis;

import java.util.HashMap;
import java.util.Map;

public class ClassScope extends Scope {
    public static void main(String[] args) {
        classInitBlocks();
        classInitOrder();
        classInitCallOrder();
    }

    private static void classInitCallOrder() {
        new InitClassChild();
    }

    private static void classInitOrder() {
        InitClass initClass = new InitClass();
    }

    private static void classInitBlocks() {
        Car car = new Car(10, "Honda");
        HondaCar honda = new HondaCar(12);

        print("car -> %s", car);
        print("honda -> %s", honda);
    }

    public static void print(String format, Object ... args) {
        System.out.printf(format + "%n", args);
    }

    public static class Car {
        private static Map<Integer, Car> STATIC_VAR;
        private static Map<Integer, Car> STATIC_VAR2;

        private Integer id;
        private String name;
        private String sum;
        private String sum2;

        {
            sum = String.valueOf(10);
        }

        {
            sum2 = String.valueOf(10);
        }

        static {
            STATIC_VAR = new HashMap<>();
        }

        static {
            STATIC_VAR2 = new HashMap<>();
        }

        public Car(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum='" + sum + '\'' +
                '}';
        }
    }

    public static class HondaCar extends Car {
        public HondaCar(Integer id) {
            super(id, "Honda");
        }
    }

    public static class InitClass {
        private static int STATIC_VAR_1 = 0;
        private static int STATIC_VAR_2 = init("STATIC_VAR_2");
        private static int STATIC_VAR_3;

        private int VAR_1 = 0;
        private int VAR_2 = init("VAR_2");
        private int VAR_3;
        private int VAR_4;

        static {
            STATIC_VAR_3 = init("STATIC_VAR_3");
        }

        {
            VAR_3 = init("VAR_3");
        }

        private static int init(String var) {
            print(var);
            return 0;
        }

        public InitClass() {
            VAR_4 = init("VAR_4");
        }
    }

    public static class InitClassParent {
        static { print("InitClassParent.static"); }
        { print("InitClassParent.initialize"); }
        public InitClassParent() { print("InitClassParent.constructor"); }
    }

    public static class InitClassChild extends InitClassParent {
        static { print("InitClassChild.static"); }
        { print("InitClassChild.initialize"); }
        public InitClassChild() { super(); print("InitClassChild.constructor"); }
    }

    public static class FinalFields {
        private final int a;

        public FinalFields() {
            this.a = 10;
        }

//        public FinalFields(int b) {
//            this();
//            this.a = 10;
//        }
    }
}
