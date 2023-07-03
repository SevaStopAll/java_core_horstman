import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTest {
    public static void main(String[] args) {
        var elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    new Class[] {Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer key = (int) (Math.random() * elements.length);

        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object t)
    {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.println(target);
        System.out.println(Arrays.toString(m.getParameters()));
        System.out.println(m.getName());
        return m.invoke(target, args);
    }


}
