package alliswell.pattern.creational.prototype;

import alliswell.pattern.creational.prototype.Resume;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("大鸟");
        a.setPersionalInfo("男", "29");
        a.setWorkExperience("1998-2000", "xx公司");

        // 克隆对象，注意深浅克隆问题
        Resume b = (Resume) a.clone();
        b.setWorkExperience("1998-2006", "yy公司");

        Resume c = (Resume) a.clone();
        c.setWorkExperience("1998-2003", "zz公司");

        a.display();
        b.display();
        c.display();
    }
}
