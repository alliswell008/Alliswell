package alliswell.demo.proxy.cglibproxy;

import alliswell.demo.proxy.A;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class CglibProxy implements MethodInterceptor {

    private CglibProxy() {

    }

    public static <T extends A> A newProxyInstance(Class<T> targetInstanceClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxy());
        return (A) enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib proxy enhance start");
        Object objProxy = proxy.invokeSuper(obj, args);
        System.out.println("cglib proxy enhance end");
        return objProxy;
    }
}

