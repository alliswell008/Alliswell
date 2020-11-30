package alliswell.demo.java8;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Nashorn JavaScript引擎
 */
public class Java8Tester8 {
    public static void main(String args[]){

        // 1.嵌入js代码
        // 2.嵌入js文件

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Runoob";
        Integer result = null;

        try {
            // 嵌入js代码
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
            System.out.println(result.toString());

            // 嵌入js文件
            //读取文件对象sample.js
            Resource sample = new ClassPathResource("sample.js");
            //执行脚本文件
            nashorn.eval(new FileReader(sample.getFile()));

            //自定义函数
            nashorn.eval("function add(a,b){ return a+b;}");
            //执行js函数
            Invocable jsInvoke = (Invocable)nashorn;
            //方法的名字，参数
            Object obj = jsInvoke.invokeFunction("add", 1,2);
            System.out.println(obj);

            //执行js函数
            Invocable jsInvoke2 = (Invocable)nashorn;
            //方法的名字，参数
            Object obj2 = jsInvoke2.invokeFunction("calculate", 1,2);
            System.out.println(obj2);
        }catch(ScriptException e){
            System.out.println("执行脚本错误: "+ e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: "+ e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException: "+ e.getMessage());
        }
    }
}