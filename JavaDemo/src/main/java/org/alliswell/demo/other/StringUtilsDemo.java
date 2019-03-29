package org.alliswell.demo.other;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsDemo {

    public static void main(String[] args) {
        diffEmptyAndBlank();
    }

    public static void diffEmptyAndBlank() {
//        isEmpty(null)------true
//        isEmpty("")------true
//        isEmpty(" ")------false
//        isEmpty("aa")----false
//
//        isBlank(null)------true
//        isBlank(" ")------true
//        isBlank(" ")------true
//        isBlank("      ")------true
//        isBlank("\t \n \f \r")------true      //制表符、换行符、换页符和回车符
//        isBlank("qqqq")------false

        // apache.commons:commons-lang3:3.8 没有区别了，使用时要注意包的版本
        System.out.println("======isEmpty======");
        System.out.println("StringUtils.isEmpty(null)" + StringUtils.isBlank(null));
        System.out.println("StringUtils.isEmpty(\"\")" + StringUtils.isBlank(""));
        System.out.println("StringUtils.isEmpty(\"   \")" + StringUtils.isBlank("   "));
        System.out.println("StringUtils.isEmpty(\"\\t \\n \\f \\r\")" + StringUtils.isBlank("\t \n \f \r"));
        System.out.println("StringUtils.isEmpty(\"aa\")" + StringUtils.isBlank("aa"));
        System.out.println("======isBlank======");
        System.out.println("StringUtils.isBlank(null)=" + StringUtils.isBlank(null));
        System.out.println("StringUtils.isBlank(\"\")=" + StringUtils.isBlank(""));
        System.out.println("StringUtils.isBlank(\"   \")=" + StringUtils.isBlank("  "));
        System.out.println("StringUtils.isBlank(\"\\t \\n \\f \\r\")=" + StringUtils.isBlank("\t \n \f \r"));
        System.out.println("StringUtils.isBlank(\"aa\")=" + StringUtils.isBlank("aa"));

    }
}
