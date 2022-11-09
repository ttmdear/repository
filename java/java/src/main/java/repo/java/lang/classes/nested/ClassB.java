package repo.java.lang.classes.nested;

public class ClassB extends ClassA {
    public class ClassBNested extends ClassA.ClassANested {
        @Override
        public void doSth() {}
    }

    public class ClassBAbstractNested extends ClassAAbstractNested {
        //                                    ^^^^^^ - abstract class
        @Override
        void doSth() {}
    }
}
