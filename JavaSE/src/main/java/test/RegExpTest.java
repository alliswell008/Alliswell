package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpTest {
 
    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }

        System.out.println("TC-U9D-MJKZQ,TC-U9MJ-D/SF,TC-3000MJ-1/SF".indexOf("TC-U9D-MJKZQ") > -1);
    }
}