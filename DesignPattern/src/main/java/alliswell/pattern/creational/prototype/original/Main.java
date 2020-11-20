package alliswell.pattern.creational.prototype.original;

/**
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Main {
    public static void main(String[] args) {
        Resume a = new Resume("大鸟");
        a.setPersionalInfo("男", "29");
        a.setWorkExperience("1998-2000", "xx公司");

        // 重新新建对象
        Resume b = new Resume("大鸟");
        b.setPersionalInfo("男", "29");
        b.setWorkExperience("1998-2000", "xx公司");

        Resume c = new Resume("大鸟");
        c.setPersionalInfo("男", "29");
        c.setWorkExperience("1998-2000", "xx公司");

        a.display();
        b.display();
        c.display();
    }
}
