package test;

import java.util.Calendar;

class StringEqualTest {
//    public static void main(String[] args) {
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program";
//        String s4 = "ming";
//        String s5 = "Program" + "ming";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2); //false
//        System.out.println(s1 == s5); //true
//        System.out.println(s1 == s6); //false
//        System.out.println(s1 == s6.intern()); //true
//        System.out.println(s2 == s2.intern()); //false
//        System.out.println(s1 == s2.intern()); //true
//        System.out.println(s1 == s5.intern()); //true
//    }


    public static void main(String[] args) {
        Calendar birth = Calendar.getInstance();
        birth.set(1975, Calendar.MAY, 26);
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