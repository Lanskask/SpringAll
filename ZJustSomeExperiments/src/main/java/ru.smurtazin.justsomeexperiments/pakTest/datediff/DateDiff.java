package ru.smurtazin.justsomeexperiments.pakTest.datediff;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class DateDiff {

    public static void main(String[] args) {
        DateDiff dateDiff = new DateDiff();
        dateDiff.run();
    }

    void run() {
        Long difference = this.countDifference(
                this.todayPlusHours(-36), new Date());
//        this.diffInHours(difference);
        this.diffInDaysAndHours(difference);
    }

    Long countDifference(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }

    void diffInDaysAndHours(Long difference) {
        Long lengthOfHour = new Long(1000 * 60 * 60);
        Long days = (difference / lengthOfHour) / 24;
        Long notDays = (difference / lengthOfHour) % 24;
        System.out.println(
            "Difference is " +
                    days + " days and "
                + notDays + " hours"
        );
    }

    void diffInHours(Long difference) {
        Long diffInHours = (difference / (1000 * 60 * 60));
        System.out.println(
            "Difference in hours is " +
                + diffInHours + " hours"
        );
    }

    Date getDateUsindLocalDateTime() {
        Date now = new Date();
        Instant instant = LocalDateTime.from(now.toInstant())
                .plusDays(1).plusHours(2)
                .toInstant(ZoneOffset.UTC);
        Date plusDayAndTwoHours = Date.from(instant);
        return plusDayAndTwoHours;
    }

    Date todayPlusHours(int hours) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.HOUR, hours);
        cal.add(Calendar.MINUTE, -24);
        return cal.getTime();
    }

}
