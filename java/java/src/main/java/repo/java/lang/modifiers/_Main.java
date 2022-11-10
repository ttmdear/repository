package repo.java.lang.modifiers;

import repo.java.lang.classes.local.Car;
import repo.java.lang.classes.nested.ClassA;
import repo.java.lang.classes.nested.PublicClass;
import repo.java.lang.classes.shadowing.MainClass;
import repo.java.lang.classes.shadowing.MainClass2;
import repo.java.lang.classes.shadowing.MainClass3;
import repo.java.lang.modifiers.pack.AbstractClass;
import repo.java.lang.modifiers.pack.PublicInterface;

public class _Main {
    private String var = "_Main";

    public static void main(String[] args) {
        // caseShadowing();
        // caseNested();
        caseLocalClass();
        caseLocalAbstractClass();
    }

    private static void caseLocalAbstractClass() {
        abstract class Animal {
            abstract void move();
        }

        final class Dog extends Animal {
            @Override
            void move() {

            }
        }

        // class SheepDog extends Dog { }
        //                        ^^^ - error
    }

    private static void caseLocalClass() {
        System.out.printf("-----------------------------------------%n");
        Car car = new Car();

        int speed = 20;
        int direction = 30;
        String var = "caseLocalClass";

        class TurnParamsLocal extends Car.TurnParams {
            private String prefix =  "ab_";
            private String var = "TurnParamsLocal";

            private static final String USER_NAME = "USER_NAME";

            private static void doSthStatic() {

            }

            @Override
            public int getSpeed() {
                return speed;
            }

            @Override
            public int getDirection() {
                return direction;
            }

            public void doSth() {
                String var = "doSth";

                System.out.printf("%s - %s - %s - %s%n", var, this.var, var, var);
            }
        }

        TurnParamsLocal turnParamsLocal = new TurnParamsLocal();

        System.out.printf("-----------------------------------------%n");
        car.turn(turnParamsLocal);
        turnParamsLocal.doSth();
    }

    private static void caseShadowing() {
        System.out.printf("-----------------------------------------%n");
        MainClass mainClass = new MainClass();

        MainClass.NestedClass nestedClass = mainClass.new NestedClass();
        MainClass.NestedStaticClass nestedStaticClass = new MainClass.NestedStaticClass();

        System.out.printf("mainClass %s%n", mainClass.getName());
        System.out.printf("nestedClass %s%n", nestedClass.getName());
        System.out.printf("nestedClass.mainName %s%n", nestedClass.getMainName());
        System.out.printf("nestedStaticClass %s%n", nestedStaticClass.getName());

        System.out.printf("-----------------------------------------%n");
        MainClass2 mainClass2 = new MainClass2();
        MainClass2.NestedClass nestedClass1 = mainClass2.new NestedClass();
        MainClass2.NestedStaticClass nestedStaticClass1 = new MainClass2.NestedStaticClass();

        System.out.printf("mainClass2 %s%n", mainClass2.getVar());
        System.out.printf("nestedClass1 %s%n", nestedClass1.getVar());
        System.out.printf("nestedClass1.mainVar %s%n", nestedClass1.getMainVar());
        System.out.printf("nestedStaticClass1 %s%n", nestedStaticClass1.getVar());
        System.out.printf("nestedStaticClass1.mainVar %s%n", nestedStaticClass1.getMainVar());

        System.out.printf("-----------------------------------------%n");
        MainClass3.NestedClass nestedClass3 = (new MainClass3()).new NestedClass();
        nestedClass3.doSth();
    }

    private static void caseNested() {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void doItAgain() {

            }
        };

        PublicClass.PublicStaticInnerClass publicStaticInnerClass = new PublicClass.PublicStaticInnerClass();

        PublicClass publicClass = new PublicClass("10");

        PublicClass.PublicInnerClass publicInnerClass = publicClass.new PublicInnerClass();
        PublicClass.PublicInnerClass publicInnerClass1 = publicClass.getPublicInnerClass();
        PublicClass.PublicInnerClass publicInnerClass2 = publicClass.getPublicInnerClass2();

        System.out.printf("PUBLIC_STATIC %s%n", PublicClass.PUBLIC_STATIC);
        System.out.printf("PUBLIC_STATIC_NESTED %s%n", PublicClass.PublicInnerClass.PUBLIC_STATIC_NESTED);

        // System.out.printf("PUBLIC_STATIC %s%n", PublicClass.PublicInnerClass.PUBLIC_STATIC);
        //                                                                      ^^^^^ - cannot ref to parent static context
    }
}
