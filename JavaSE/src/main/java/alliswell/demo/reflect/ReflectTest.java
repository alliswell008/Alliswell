package alliswell.demo.reflect;

import alliswell.AttributeUtil;
import cn.hutool.core.util.ReflectUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Title: ReflectTest
 * @Package alliswell.demo.reflect
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/25 14:08
 * @Version V1.0
 * <p>
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public class ReflectTest {
    public static void main(String[] args) {
        callStaticMethod();
        System.out.println("==================");
        constructorSort();
        System.out.println("==================");
        getActualType();
        System.out.println("==================");
        compare();

    }

    public static void callStaticMethod() {
        try {
            Class<ReflectDemo> c = ReflectDemo.class;
            Method main = c.getMethod("main", String[].class);
            // 静态方法反射调用时，第一个参数为null
            main.invoke(null, (Object) null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void constructorSort() {
        Class<ReflectDemo> c = ReflectDemo.class;
        // getDeclaredConstructors获取的构造方法包含private和public
        // getConstructors获取的构造方法只包含public
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();

        try {
            // 私有方法访问权限设置为true，否则会抛异常java.lang.IllegalAccessException
            declaredConstructors[3].setAccessible(true);

            // 反射获得到的方法与源码中的顺序是相反的，需要注意
            ReflectDemo d0 = (ReflectDemo) declaredConstructors[3].newInstance();
            ReflectDemo d1 = (ReflectDemo) declaredConstructors[2].newInstance("name");
            ReflectDemo d2 = (ReflectDemo) declaredConstructors[1].newInstance(11);
            ReflectDemo d3 = (ReflectDemo) declaredConstructors[0].newInstance("name", 111);

            System.out.println(d0);
            System.out.println(d1);
            System.out.println(d2);
            System.out.println(d3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void getActualType() {
        Class<ReflectDemo> c = ReflectDemo.class;
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            Type type = method.getGenericReturnType();
            // 判断是否参数化类型，例如List<String>是参数化类型
            if (type instanceof ParameterizedType) {
                System.out.println(type.getTypeName());
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument.getTypeName());
                }
            }
        }

        System.out.println("-------------");

        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Type type = declaredField.getGenericType();
            if (type instanceof ParameterizedType) {
                System.out.println(type.getTypeName());
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument.getTypeName());
                }
            }
        }
    }


    public static void compare() {
        ReflectDemo r1 = new ReflectDemo("张三",1);
        ReflectDemo r2 = new ReflectDemo("李四",2);


        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor("age", ReflectDemo.class);
            Method getMethod = pd.getReadMethod();
            Object invoke = getMethod.invoke(r1);
            System.out.println("------"+invoke);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // TODO 这个方法可能存在线程安全的问题，可考虑上面的方式
        // 比较两个对象的属性，并返回发生变更的属性集合
        List<AttributeUtil.Attribute> compare = AttributeUtil.compare(r1, r2);
        System.out.println(compare);
    }
}
