package alliswell.demo.date;

import java.util.Calendar;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2019/8/15
 */
public class CalenderDemo {

    public static void main(String[] args) {
        // 单例对象，多次使用时不能直接修改，需要克隆后再使用
        Calendar birth = Calendar.getInstance();
        birth.set(2019, Calendar.AUGUST, 10);
        Calendar now = Calendar.getInstance();
        System.out.println(daysBetween(birth, now));
        System.out.println(daysBetween(birth, now)); // 显示 0？
//        birth.set(1975, Calendar.MAY, 26);
        System.out.println(daysBetween(birth, now)); // 显示 0？
    }

    public static long daysBetween(Calendar begin, Calendar end) {
        Calendar calendar = (Calendar) begin.clone(); // 复制
        long daysBetween = 0;
//        while (begin.before(end)) {
        while (calendar.before(end)) {
//            begin.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }
}
