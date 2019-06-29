package alliswell.demo.jvm;

public class GetClassLoader {
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass()
                + " 加载进来的");
    }

    public static void main(String[] args) {
        System.out.println(System.class.getClassLoader());
        System.out.println(ClassLoader.getSystemResource("java/lang/String.class"));
        java.net.URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls.toExternalForm());
        }

        System.out.println(GetClassLoader.class.getName());
        System.out.println(GetClassLoader.class.getSimpleName());
        System.out.println(GetClassLoader.class.isEnum());

        Class c = int.class;
        Class c1 = Integer.class;
        Class<? extends Number> obj=int.class;
        obj=Number.class;
        obj=double.class;

        Class<?> obj1=int.class;
        obj1=double.class;
        obj1=GetClassLoader.class;


        Class<Round> rclass=Round.class;
//        Class<? super Round> sclass= rclass.getSuperclass();
        Class<Shapes> sclass= (Class<Shapes>) rclass.getSuperclass();

        // 判断类是否是指定类或类的父类
        System.out.println(rclass.isAssignableFrom(sclass));
        System.out.println(sclass.isAssignableFrom(rclass));
        // 判断对象实例是否是指定类或类的子类
        System.out.println(new Round() instanceof Shapes);

        System.out.println(void.class.getName());
        System.out.println(Void.class.getName());
        System.out.println(int.class.getName());
        System.out.println(Integer.class.getName());
        System.out.println(boolean.class.getName());
        System.out.println(Boolean.class.getName());
    }
}
class Shapes{}
class Round extends Shapes{}