/**
 * @Title:
 * @Package com.allis.core.base.component
 * @Description: TODO(用一句话描述该文件做什么)
 * @author org.alliswell
 * @date 2016/9/26 16:03
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package org.alliswell.base.component;


import com.allis.core.mgruser.model.dto.UserDto;
import com.allis.core.mgruser.service.UserService;
import com.allis.core.mgruser.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author org.alliswell
 * @ClassName: ProxyUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016/9/26 16:03
 * <p/>
 * ${TAGS}
 */
public class ProxyUtil implements InvocationHandler
{
    private Object target;    // 被代理的对象

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable
    {
        System.out.println("do sth before....");
        Object result = method.invoke(target, args);
        System.out.println("do sth after....");
        return result;
    }

    ProxyUtil(Object target)
    {
        this.target = target;
    }

    public Object getTarget()
    {
        return target;
    }

    public void setTarget(Object target)
    {
        this.target = target;
    }

    public static void main(String[] args){
        Object proxyedObject = new UserServiceImpl();    // 被代理的对象
        ProxyUtil proxyUtils = new ProxyUtil(proxyedObject);

        // 生成代理对象，对被代理对象的这些接口进行代理：UserServiceImpl.class.getInterfaces()
        UserService proxyObject = (UserService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                UserServiceImpl.class.getInterfaces(), proxyUtils);
        proxyObject.getUser("1");
        proxyObject.addUser(new UserDto());
    }
}