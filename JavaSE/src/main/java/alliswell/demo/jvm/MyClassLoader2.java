package alliswell.demo.jvm;

import java.io.FileInputStream;

/**
 * 自定义类加载器，需要重写loadClass()方法
 * defineClass()方法实现字节码转化成Class对象
 */
public class MyClassLoader2 extends ClassLoader {
    private String classPath;

    public MyClassLoader2(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    private byte[] loadByte(String classPath, String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    /**
     * 破坏了org.a.demo.jvm.HelloClassLoader类的双亲委派模型，其他类仍按双亲委派模型加载
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // return super.loadClass(name);
        // 这里可以根据不同条件，来区分使用不同的类加载器
        if (!"HelloClassLoader".equals(name)) {
            return super.loadClass(name);
        } else {
            String myPath = "D:\\a\\workspace\\Alliswell\\JavaDemo\\target\\classes\\";

            byte[] classBytes = null;
            try {
                classBytes = loadByte(myPath, name);
            } catch (Exception e) {
//                e.printStackTrace();
            }

            Class<?> clazz = null;
            if (classBytes != null) {
                System.out.println(myPath);
                System.out.println();
                clazz = defineClass(name, classBytes, 0, classBytes.length);
            } else {
                System.out.println(classPath);
                System.out.println();
                clazz = findClass(name);
            }
            return clazz;
        }
    }
}
