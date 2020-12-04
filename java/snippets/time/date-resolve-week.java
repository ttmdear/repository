/**
 * Funckja określa początek i koniec tygodnia dla określonej daty.
 * Dane są przekazywane do struktury DatePeriod.
 */

public class DatePeriod {
    private final Date from;
    private final Date to;
}

public static DatePeriod resolveWeekDatePeriod(Date date) {
    Calendar calendarFrom = Calendar.getInstance();
    calendarFrom.setTime(date);
    calendarFrom.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    calendarFrom.set(Calendar.HOUR_OF_DAY, 0);
    calendarFrom.set(Calendar.MINUTE, 0);
    calendarFrom.set(Calendar.SECOND, 0);

    Calendar calendarTo = Calendar.getInstance();
    calendarTo.setTime(date);
    calendarTo.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    calendarTo.set(Calendar.HOUR_OF_DAY, 23);
    calendarTo.set(Calendar.MINUTE, 59);
    calendarTo.set(Calendar.SECOND, 59);

    return new DatePeriod(calendarFrom.getTime(), calendarTo.getTime());
}
