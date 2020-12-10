package alliswell.demo.proxy.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtField.Initializer;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassistTest {

    public static void main(String[] args) {
        try {
            testJavassist();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("================");
        testFrozen();
        System.out.println("================");
        loadAndUseStudent();
    }

    public static void testJavassist() throws CannotCompileException,
            NotFoundException, SecurityException, NoSuchMethodException,
            InstantiationException, IllegalAccessException,
            ClassNotFoundException, IllegalArgumentException,
            InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cls = pool.makeClass("org.a.demo.proxy.javassist.Test");

        // 添加私有成员name及其getter、setter方法
        CtField param = new CtField(pool.get("java.lang.String"), "name", cls);
        param.setModifiers(Modifier.PRIVATE);
        cls.addMethod(CtNewMethod.setter("setName", param));
        cls.addMethod(CtNewMethod.getter("getName", param));
        cls.addField(param, Initializer.constant(""));

        // 添加无参的构造体
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cls);
        cons.setBody("{name = \"Brant\";}");
        cls.addConstructor(cons);

        // 添加有参的构造体
        cons = new CtConstructor(
                new CtClass[]{pool.get("java.lang.String")}, cls);
        cons.setBody("{$0.name = $1;}");
        cls.addConstructor(cons);

        // 打印创建类的类名
        System.out.println("类名:" + cls.toClass());

        // 通过反射创建无参的实例，并调用getName方法
        Object o = Class.forName("org.a.demo.proxy.javassist.Test").newInstance();
        Method getter = o.getClass().getMethod("getName");
        System.out.println("name: " + getter.invoke(o));

        // 调用其setName方法
        Method setter = o.getClass().getMethod("setName",
                new Class[]{String.class});
        setter.invoke(o, "Adam");
        System.out.println("name: " + getter.invoke(o));

        // 通过反射创建有参的实例，并调用getName方法
        o = Class.forName("org.a.demo.proxy.javassist.Test")
                .getConstructor(String.class).newInstance("Liu Jian");
        getter = o.getClass().getMethod("getName");
        System.out.println("name: " + getter.invoke(o));
    }

    public static void testFrozen() {
        //默认的类搜索路径
        ClassPool classPool = ClassPool.getDefault();
        //创建一个ctClass对象
        CtClass ctClass = classPool.makeClass("com.lwj.mom.base.javassist.Student");
        try {
            //添加age属性
            ctClass.addField(CtField.make("private int age;", ctClass));
            //添加setAge方法
            ctClass.addMethod(CtMethod.make("public void setAge(int age){this.age = age;}", ctClass));
            //添加getAge方法
            ctClass.addMethod(CtMethod.make("public int getAge(){return this.age;}", ctClass));

            //将ctClass转换成字节码并写入文件
//            byte[] byteArray = ctClass.toBytecode();
//            File file = new File("D:\\com\\lwj\\mom\\base\\javassist");
//            if (!file.exists()) file.mkdirs();
//            FileOutputStream output = new FileOutputStream("D:\\com\\lwj\\mom\\base\\javassist\\Student.class");
//            output.write(byteArray);
//            output.close();
//            System.out.println("文件写入成功!!!");

            // 如果一个CtClass对象通过writeFile（）,toClass（）或者toByteCode（）转换成class文件，
            // 那么javassist会冻结这个CtClass对象。后面就不能修改这个CtClass对象了。
            // 这样是为了警告开发者不要修改已经被JVM加载的class文件，因为JVM不允许重新加载一个类。
            // 如果一定要修改，可以放开下面的代码，否则就会抛出异常：Exception in thread "main" java.lang.RuntimeException: com.lwj.mom.base.javassist.Student class is frozen
            if (ctClass.isFrozen()) {
                ctClass.defrost();
            }

            //这里用pool.get()去获取ctClass对象，表示默认JVM已经加载此类.
            ctClass = classPool.get("com.lwj.mom.base.javassist.Student");
            ctClass.addField(CtField.make("private String sex;", ctClass));
            ctClass.addField(CtField.make("private String name;", ctClass));

            CtMethod setAge = ctClass.getDeclaredMethod("setAge");
            ctClass.removeMethod(setAge);
            ctClass.addMethod(CtMethod.make("public com.lwj.mom.base.javassist.Student setAge(int age){this.age = age; return this;}", ctClass));
            ctClass.addMethod(CtMethod.make("public String toString() {\n" +
                    "        return \"Student{\" +\n" +
                    "                \"age=\" + age +\n" +
                    "                \", sex='\" + sex + '\\'' +\n" +
                    "                \", name='\" + name + '\\'' +\n" +
                    "                '}';\n" +
                    "    }", ctClass));

//            byteArray = ctClass.toBytecode();
//            output = new FileOutputStream("D:\\com\\lwj\\mom\\base\\javassist\\Student.class");
//            output.write(byteArray);
//            output.close();
//            System.out.println("文件修改成功!!!!");

            // 打印创建类的类名
            System.out.println("类名:" + ctClass.toClass());

        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadAndUseStudent() {
        try {
//            ClassLoader classLoader = new MyClassLoader("D:\\");
//            Class<?> clazz = classLoader.loadClass("com.lwj.mom.base.javassist.Student");
//            Object o = clazz.newInstance();
//            Method setAge = o.getClass().getMethod("setAge", int.class);
//            setAge.invoke(o, 10);
//            Method getAge = o.getClass().getDeclaredMethod("getAge");
//            Object invoke = getAge.invoke(o);
//            System.out.println(invoke.toString());
//            System.out.println(o.toString());

            // 通过反射创建无参的实例，并调用getName方法
            Object o1 = Class.forName("com.lwj.mom.base.javassist.Student").newInstance();
            Method getter = o1.getClass().getMethod("getAge");
            Method setAge1 = o1.getClass().getMethod("setAge", int.class);
            setAge1.invoke(o1, 11);
            System.out.println("age: " + getter.invoke(o1));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}