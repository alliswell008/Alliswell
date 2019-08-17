// 包名
package alliswell.demo.name;

/**
 * 命名原则：可读性高，见名知意<br/>
 * 标识符：由英文字符大小写（a~zA~Z）、数字(0~9)、其他文字以及部分特殊字符（有下划线(_)、美元符号($)和人民币符号(￥)）组成<br/>
 * 标识符组合规则：数字不能作为首个标识符，严格区分大小写，可以为任意长度<br/>
 * 包名：英文字母都要小写，使用时以点号“.”分隔不同的包（例:package  com.baidu）<br/>
 * 类名和接口名：首个标识符为英文字母要大写，驼峰命名(例：HelloWorld)<br/>
 * 变量名和方法名：首个标识符为英文字母要小写，驼峰命名（例：lastAccessTime、getTime）<br/>
 * 常量名（即符号常量，与之相对的称为字面常量，如1，2，'a'，'b'）：英文字母都要大写，单词之间以“_”分隔（例：INTEGER_CACHE）<br/>
 *
 * @author chengxs
 * @date 2019/8/3
 */
// 类名
public class ￥NameRule1 {

    // 常量名
    private final double 我_PI = 3.14D;

    //  方法名
    public void 我nameMethod() {
        // 变量名
        int intVar = 0;
    }
}
