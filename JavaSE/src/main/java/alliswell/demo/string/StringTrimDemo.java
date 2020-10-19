package alliswell.demo.string;

import org.apache.commons.lang3.StringUtils;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/6/17
 */
public class StringTrimDemo {
    public static void main(String[] args) {
        // 【" ":&#160;】和【" ":&#32;】是两种空字符，前一种不能用trim去掉，要用replace替换
        String str = " "; // " ":&#160;
        System.out.println(1+ StringUtils.trim(str)+2);
        str = " "; // " ":&#32;
        System.out.println(1+StringUtils.trim(str)+2);
        str = "  "; // " ":&#160;
        System.out.println(1+StringUtils.replace(StringUtils.replace(str, " ", ""), " ", "")+2);
    }
}
