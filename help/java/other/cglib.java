public class PersonService {
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}

// ---------------------------
// Returning the Same Value
// ---------------------------
Enhancer enhancer = new Enhancer();
enhancer.setSuperclass(PersonService.class);
enhancer.setCallback((FixedValue) () -> "Hello Tom!");
PersonService proxy = (PersonService) enhancer.create();

String res = proxy.sayHello(null);

assertEquals("Hello Tom!", res);

// ---------------------------
// Returning Value Depending on a Method Signature
// ---------------------------
Enhancer enhancer = new Enhancer();
enhancer.setSuperclass(PersonService.class);
enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
    if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
        return "Hello Tom!";
    } else {
        return proxy.invokeSuper(obj, args);
    }
});

PersonService proxy = (PersonService) enhancer.create();

assertEquals("Hello Tom!", proxy.sayHello(null));
int lengthOfName = proxy.lengthOfName("Mary");

assertEquals(4, lengthOfName);

// ---------------------------
// Bean Creator
// ---------------------------
BeanGenerator beanGenerator = new BeanGenerator();

beanGenerator.addProperty("name", String.class);
Object myBean = beanGenerator.create();
Method setter = myBean.getClass().getMethod("setName", String.class);
setter.invoke(myBean, "some string value set by a cglib");

Method getter = myBean.getClass().getMethod("getName");
assertEquals("some string value set by a cglib", getter.invoke(myBean));

// ---------------------------
// Creating Mixin
// ---------------------------
public interface Interface1 {
    String first();
}

public interface Interface2 {
    String second();
}

public class Class1 implements Interface1 {
    @Override
    public String first() {
        return "first behaviour";
    }
}

public class Class2 implements Interface2 {
    @Override
    public String second() {
        return "second behaviour";
    }
}

public interface MixinInterface extends Interface1, Interface2 { }

Mixin mixin = Mixin.create(
  new Class[]{ Interface1.class, Interface2.class, MixinInterface.class },
  new Object[]{ new Class1(), new Class2() }
);
MixinInterface mixinDelegate = (MixinInterface) mixin;

assertEquals("first behaviour", mixinDelegate.first());
assertEquals("second behaviour", mixinDelegate.second());
