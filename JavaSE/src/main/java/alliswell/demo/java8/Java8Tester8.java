package alliswell.demo.java8;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            //执行脚本
            nashorn.eval(new FileReader(sample.getFile()));
        }catch(ScriptException e){
            System.out.println("执行脚本错误: "+ e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: "+ e.getMessage());
        }
    }
}