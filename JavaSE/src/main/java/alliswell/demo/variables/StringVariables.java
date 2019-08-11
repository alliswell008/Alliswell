package alliswell.demo.variables;

/**
 * @Title: StringVariables
 * @Package alliswell.demo.variables
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/8/11 15:03
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
public class StringVariables {
    public static void main(String[] args) {
        String s1 = "Programming";
        // 创建一个新的字符串对象
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        // intern()方法从常量池中取出已经存在的对象
        System.out.println(s1 == s2.intern());
        System.out.println(s2 == s2.intern());
    }
}
