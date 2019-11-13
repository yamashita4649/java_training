package ch10.ex03;

public class Working {
    public static boolean isWorkingDayIf(Week week) {
        boolean ret;
        if(week == Week.MON) {
            ret = true;
        } else if(week == Week.TUE) {
            ret = true;
        }else if(week == Week.WED) {
            ret = true;
        }else if(week == Week.THU) {
            ret = true;
        }else if(week == Week.FRI) {
            ret = true;
        }else if(week == Week.SAT) {
            ret = false;
        }else if(week == Week.SUN) {
            ret = false;
        } else {
            ret = false;
        }
        return ret;
    }

    //こっちのほうが明瞭
    public static boolean isWorkingDaySwitch(Week week) {
        boolean ret;
        switch (week) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                ret = true;
                break;
            case SAT:
            case SUN:
            default:
                ret = false;
                break;
        }
        return ret;
    }

    public static void main(String[] args) {

        System.out.println("Mon = " +isWorkingDayIf(Week.MON));
        System.out.println("Tue = " +isWorkingDayIf(Week.TUE));
        System.out.println("Wed = " +isWorkingDayIf(Week.WED));
        System.out.println("Thu = " +isWorkingDayIf(Week.THU));
        System.out.println("Fri = " +isWorkingDayIf(Week.FRI));
        System.out.println("Sat = " +isWorkingDayIf(Week.SAT));
        System.out.println("Sun = " +isWorkingDayIf(Week.SUN));

        System.out.println("Mon = " +isWorkingDaySwitch(Week.MON));
        System.out.println("Tue = " +isWorkingDaySwitch(Week.TUE));
        System.out.println("Wed = " +isWorkingDaySwitch(Week.WED));
        System.out.println("Thu = " +isWorkingDaySwitch(Week.THU));
        System.out.println("Fri = " +isWorkingDaySwitch(Week.FRI));
        System.out.println("Sat = " +isWorkingDaySwitch(Week.SAT));
        System.out.println("Sun = " +isWorkingDaySwitch(Week.SUN));
    }
}
