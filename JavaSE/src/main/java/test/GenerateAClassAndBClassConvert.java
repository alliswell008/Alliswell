package test;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * 生成A类与B类转换
 *
 * @author chengxs
 * @date 2020/4/5
 */
public class GenerateAClassAndBClassConvert {

    private static String clazzName;
    private static String clazzAName;
    private static String clazzBName;
    private static File file;

    public static void main(String[] args) {
        try {

            Class clazz = Class.forName("test.Cal");//根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
            Class clazzB = Class.forName("test.Cal2");
            setConvertClassName("./", clazz, clazzB);

            // if file doesnt exists, then create it
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            } else {
                file.createNewFile();
            }

            String content = assemContent(clazz, clazzB);
            write(content);
            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成转换类
     *
     * @param path
     * @param className
     * @return
     */
    public static void setConvertClassName(String path, Class clazzA, Class clazzB) {
        clazzAName = firstUpper(clazzA.getSimpleName());
        clazzBName = firstUpper(clazzB.getSimpleName());
        clazzName = clazzAName + "And" + clazzBName + "Convert";
        file = new File(path + clazzName + ".java");
    }

    /**
     * 写入转换类的内容
     *
     * @param content
     */
    public static void write(String content) {

        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(file);
            // get the content in bytes
            byte[] contentInBytes = content.toString().getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 组装转换类的内容
     *
     * @return
     */
    public static String assemContent(Class clazzA, Class clazzB) {


        Set<String> importSet = new HashSet<String>();
        importSet.add(clazzA.getName());
        importSet.add(clazzB.getName());
        importSet.add("java.util.List");
        importSet.add("java.util.ArrayList");

        //根据Class对象获得属性 私有的也可以获得
        for (Field f : clazzA.getDeclaredFields()) {
            importSet.add(f.getType().getName());
        }

        for (Field f : clazzB.getDeclaredFields()) {
            importSet.add(f.getType().getName());
        }


        StringBuffer content = new StringBuffer("");
        content.append("package demo.convert;\n");
        for (String s : importSet) {
            content.append("import " + s + ";\n");
        }


        content.append("/**\n");
        content.append(" * create by liangmeiwei's tool\n");
        content.append(" */\n");

        content.append("public class " + clazzName + "{" + "\n");
        //classAToClassB
        content.append("\t/**\n");
        content.append("\t * " + firstLower(clazzAName) + "To" + clazzBName + "\n");
        content.append("\t */\n");

        content.append("\tpublic static " + clazzBName + " " + firstLower(clazzAName) + "To" + clazzBName + "(" + clazzAName + " " + firstLower(clazzAName) + ")" + "{\n");
        content.append("\t\tif(" + firstLower(clazzAName) + " == null){\n");
        content.append("\t\t\treturn null;\n");
        content.append("\t\t}\n");
        content.append("\t\t" + clazzBName + " " + firstLower(clazzBName) + " = new " + clazzBName + "();\n");
        for (Field f : clazzB.getDeclaredFields()) {
            content.append("\t\t" + firstLower(clazzBName) + ".set" + firstUpper(f.getName()) + "(" + firstLower(clazzAName) + ".get" + firstUpper(f.getName()) + "());\n");
        }
        content.append("\t\treturn " + firstLower(clazzBName) + ";\n");
        content.append("\t}\n\n");

        //classBToClassA
        content.append("\t/**\n");
        content.append("\t * " + firstLower(clazzBName) + "To" + clazzAName + "\n");
        content.append("\t */\n");

        content.append("\tpublic static " + clazzAName + " " + firstLower(clazzBName) + "To" + clazzAName + "(" + clazzBName + " " + firstLower(clazzBName) + ")" + "{\n");
        content.append("\t\tif(" + firstLower(clazzBName) + " == null){\n");
        content.append("\t\t\treturn null;\n");
        content.append("\t\t}\n");
        content.append("\t\t" + clazzAName + " " + firstLower(clazzAName) + " = new " + clazzAName + "();\n");
        for (Field f : clazzA.getDeclaredFields()) {
            content.append("\t\t" + firstLower(clazzAName) + ".set" + firstUpper(f.getName()) + "(" + firstLower(clazzBName) + ".get" + firstUpper(f.getName()) + "());\n");
        }
        content.append("\t\treturn " + firstLower(clazzAName) + ";\n");
        content.append("\t}\n\n");

//        //classListToClassBList
//        content.append("public static List<" + clazzBSimpleName + ">" + clazzName + "ListTo" + clazzBSimpleName + "List(" + "List<" + clazzSimpleName + "> " + clazzName + "List){\n");
//        content.append("if(" + clazzName + "List == null" + "){\n");
//        content.append("return null;\n");
//        content.append("}\n");
//        content.append("List<" + clazzBSimpleName + ">" + clazzBName + "List = new ArrayList();\n");
//        content.append("for(" + clazzSimpleName + " " + clazzName + " : " + clazzName + "List" + "){\n");
//        content.append(clazzBName + "List.add(" + clazzName + "To" + clazzBSimpleName + "(" + clazzName + ")" + ");\n");
//        content.append("}\n");
//        content.append("return " + clazzBName + "List;\n");
//        content.append("}\n");
//
//
//        //classBListToClassList
//        content.append("public static List<" + clazzSimpleName + ">" + clazzBName + "ListTo" + clazzSimpleName + "List(" + "List<" + clazzBSimpleName + "> " + clazzBName + "List){\n");
//        content.append("if(" + clazzBName + "List == null" + "){\n");
//        content.append("return null;\n");
//        content.append("}\n");
//        content.append("List<" + clazzSimpleName + ">" + clazzName + "List = new ArrayList();\n");
//        content.append("for(" + clazzBSimpleName + " " + clazzBName + " : " + clazzBName + "List" + "){\n");
//        content.append(clazzName + "List.add(" + clazzBName + "To" + clazzSimpleName + "(" + clazzBName + ")" + ");\n");
//        content.append("}\n");
//        content.append("return " + clazzName + "List;\n");

        content.append("}\n");

        return content.toString();
    }


    public static String firstUpper(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String firstLower(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
}

