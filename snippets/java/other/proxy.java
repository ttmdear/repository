public class DynamicInvocationHandler implements InvocationHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(
      DynamicInvocationHandler.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
        LOGGER.info("Invoked method: {}", method.getName());

        return 42;
    }
}

Map proxyInstance = (Map) Proxy.newProxyInstance(
  DynamicProxyTest.class.getClassLoader(),
  new Class[] { Map.class },
  new DynamicInvocationHandler());

// Lub
Map proxyInstance = (Map) Proxy.newProxyInstance(
  DynamicProxyTest.class.getClassLoader(),
  new Class[] { Map.class },
  (proxy, method, methodArgs) -> {
    if (method.getName().equals("get")) {
        return 42;
    } else {
        throw new UnsupportedOperationException(
          "Unsupported method: " + method.getName());
    }
});
