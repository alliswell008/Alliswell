package alliswell.demo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/5/18
 */
public class GlmapperGeneric<T> {
    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }

    /** 泛型方法与可变参数结合 */
    public <K> K fun(K... k) {
        for (K a : k) {
            if (a instanceof Float) {
                System.out.println("float:"+a);
            }
            else if (a instanceof String) {
                System.out.println("string:"+a);
            }
            else if (a instanceof Integer) {
                System.out.println("integer:"+a);
            }
            else if (a instanceof Object) {
                System.out.println("Object:"+a);
            }

        }
        return k[k.length - 1];
    }

    /** 静态泛型方法必须重新声明泛型，且声明的泛型T不同于泛型类上的T */
    public static <T> void show(T t){

    }

    public static void main(String[] args) {
        // do nothing
        GlmapperGeneric<Object> t = new GlmapperGeneric<>();
        t.testGeneric();
        t.noSpecifyType();
        t.specifyType();
        t.fun(112, "ss", 21.23f, new Object());
    }

    /**
     * Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦除，
     * 并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。
     */
    public void testGeneric() {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();
        stringArrayList.add("aaa");
        integerArrayList.add(123);

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试-类型相同");
        }
    }

    /**
     * 不指定类型
     */
    public void noSpecifyType(){
        GlmapperGeneric glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("test");
        // 需要强制类型转换
        String test = (String) glmapperGeneric.get();
        System.out.println(test);
    }

    /**
     * 指定类型
     */
    public void specifyType(){
        GlmapperGeneric<String> glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("test");
        // 不需要强制类型转换
        String test = glmapperGeneric.get();
        System.out.println(test);
    }
}
