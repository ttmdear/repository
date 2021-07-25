package repo.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // proxyFixValue();
        proxyFixWithInterceptor();
    }

    private static void proxyFixWithInterceptor() {
        System.out.println("proxyFixWithInterceptor");

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws
                Throwable {

                System.out.println(method.getDeclaringClass());
                System.out.println(method.getReturnType());

                System.out.println(proxy.getClass());
                System.out.println(method.getName());
                // System.out.println(Arrays.asList(o, method, objects));

                return null;
            }
        });

        UserService userServiceProxy = (UserService) enhancer.create();

        userServiceProxy.findByName("Paweł");
    }

    private static void proxyFixValue() {
        System.out.println("proxyFixValue");

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Fixed value";
            }
        });

        UserService userServiceProxy = (UserService) enhancer.create();

        userServiceProxy.findByName("Paweł");
    }
}
