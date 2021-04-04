package alliswell.app.calendar;

/**
 * 干支纪年
 */
public class SexagenaryCycle {

    public static void main(String[] args) {
        String sexagenaryCycle = getSexagenaryCycle(2021);
        System.out.println(sexagenaryCycle);


        String name = DayOf12HourEnum.getEnumByHour(25).getAlias();
        System.out.println(name);

    }

    public static String getSexagenaryCycle(int year) {
        String stemStr = StemEnum.getEnumByYear(year).getName();
        String brancheStr = BrancheEnum.getEnumByYear(year).getName();
        return stemStr + brancheStr;
    }
}
