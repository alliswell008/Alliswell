/**
 * 文件注释
 */
package alliswell.demo.annotation;

/**
 * 类注释
 *
 * @author chengxs
 * @date 2020/6/23
 */
public class CodeAnnotation {
    /**
     * 无返回方法注释
     *
     * @param args 参数说明
     */
    public static void main(String[] args) {
        // 单行注释\u000d\u000a System.out.println("注释中的换行符：\\u000d\\u000a");

        /**
         * 代码块注释
         */
        // 分支注释
        if (false) {
        }
        // 分支注释
        else {
        }
    }

    /**
     * 有返回方法注释
     *
     * @param arg 参数说明
     * @return 返回说明
     */
    public boolean fun(int arg) {
        return false;
    }
}
