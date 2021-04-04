package alliswell.app.calendar;

import alliswell.demo.proxy.A;

/**
 * 一天十二时辰
 */
public enum DayOf12HourEnum {
    Zi(23, 1, "子时"), Chou(1, 3, "丑时"), Yin(3, 5, "寅时"), Mao(5, 7, "卯时"),
    Chen(7, 9, "辰时"), Si(9, 11, "巳时"), Wu(11, 13, "午时"), Wei(13, 15, "未时"),
    Shen(15, 17, "申时"), You(17, 19, "酉时"), Xu(19, 21, "戌时"), Hai(21, 23, "亥时");

    private final int start;
    private final int end;
    private final String name;

    DayOf12HourEnum(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    public static DayOf12HourEnum getEnumByHour(int hour) {
        int code = hour % 24;
        assert code > -1 && code < 24 : "参数超出允许的范围";

        for (DayOf12HourEnum dayOf12HourEnum : DayOf12HourEnum.values()) {
            if (dayOf12HourEnum.start > dayOf12HourEnum.end) {
                if (dayOf12HourEnum.start <= code || code < dayOf12HourEnum.end) {
                    return dayOf12HourEnum;
                }
            } else {
                if (dayOf12HourEnum.start <= code && code < dayOf12HourEnum.end) {
                    return dayOf12HourEnum;
                }
            }
        }
        return null;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        for (Alias alias : Alias.values()) {
            if (this.name().equals(alias.name())) {
                return alias.name;
            }
        }
        return null;
    }

    private enum Alias {
        Zi("夜半"), Chou("鸡鸣"), Yin("平旦"), Mao("日出"),
        Chen("食时"), Si("隅中"), Wu("日中"), Wei("日昳"),
        Shen("哺时"), You("日入"), Xu("黄昏"), Hai("人定");

        private final String name;

        Alias(String name) {
            this.name = name;
        }
    }
}
