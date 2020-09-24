package com.edu.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class DateUtils {

    public static void main(String[] args) {
        //LocalDateTime dtm = DateUtils.getLocalDateTime("2019-08-05 17:46:55.448", "yyyy-MM-dd HH:mm:ss.SSS")
    	LocalDateTime dtm = LocalDateTime.of(2020, 9, 22, 23, 59, 59);
        String elapsed = DateUtils.getElapsed(dtm);
        System.out.println("> from    : " + DateUtils.getDateTime(dtm, DF_FULL));
        System.out.println("> cur     : " + DateUtils.getDateTime(DF_FULL));
        System.out.println("> elapsed : " + elapsed);
    }
    
    private DateUtils() {
        // should not be Instances
    }

    public static final int               _DA               = 24 * 60 * 60 * 1000;
    public static final int               _HO               = 60 * 60 * 1000;
    public static final int               _MI               = 60 * 1000;
    public static final int               _SE               = 1000;

    public static final DateTimeFormatter DF_FULL           = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateTimeFormatter DF_DEFAULT        = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DF_SHORT          = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter DF_COMPACT        = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter DF_DATE           = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DF_TIME           = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final String            MON_KEY_UUID      = "MON_KEY_UUID";
    public static final String            MON_KEY_REQ_DTM   = "MON_KEY_REQ_DTM";
    public static final String            MON_KEY_RCV_DTM   = "MON_KEY_RCV_DTM";
    public static final String            MON_KEY_CMPLT_DTM = "MON_KEY_CMPLT_DTM";

    public static final SimpleDateFormat  S_DATE_FORMAT     = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


    public static String getDate() {
        return DateUtils.DF_DATE.format(LocalDate.now());
    }

    public static String getDate(DateTimeFormatter formatter) {
        return formatter.format(LocalDate.now());
    }

    public static String getDate(LocalDate dt, DateTimeFormatter formatter) {
        return formatter.format(dt);
    }

    public static String getTime() {
        return DateUtils.DF_TIME.format(LocalTime.now());
    }

    public static String getTime(DateTimeFormatter formatter) {
        return formatter.format(LocalTime.now());
    }

    public static String getTime(LocalTime tm, DateTimeFormatter formatter) {
        return formatter.format(tm);
    }

    public static String getDateTime() {
        return DateUtils.DF_DEFAULT.format(LocalDateTime.now());
    }

    public static String getDateTime(DateTimeFormatter formatter) {
        return formatter.format(LocalDateTime.now());
    }

    public static String getDateTime(LocalDateTime dtm, DateTimeFormatter formatter) {
        return formatter.format(dtm);
    }

    public static String getPeriod(LocalDateTime from, LocalDateTime to) {
        // temp
        LocalDateTime tmp = LocalDateTime.from(from);

        long days = tmp.until(to, ChronoUnit.DAYS);
        tmp = tmp.plusDays(days);

        long hours = tmp.until(to, ChronoUnit.HOURS);
        tmp = tmp.plusHours(hours);

        long minutes = tmp.until(to, ChronoUnit.MINUTES);
        tmp = tmp.plusMinutes(minutes);

        long seconds = tmp.until(to, ChronoUnit.SECONDS);

        return days + "D" + hours + "H" + minutes + "M" + seconds + "S";
    }

    public static String getElapsed(LocalDateTime from) {
        LocalDateTime to = LocalDateTime.now();

        LocalDateTime tmp = LocalDateTime.from(from);

        long days = tmp.until(to, ChronoUnit.DAYS);
        tmp = tmp.plusDays(days);

        long hours = tmp.until(to, ChronoUnit.HOURS);
        tmp = tmp.plusHours(hours);

        long minutes = tmp.until(to, ChronoUnit.MINUTES);
        tmp = tmp.plusMinutes(minutes);

        long seconds = tmp.until(to, ChronoUnit.SECONDS);

        return days + "D" + hours + "H" + minutes + "M" + seconds + "S";
    }

    public static long getDelayTime(String from, String to) {
        if(from == null || from.isEmpty() || to == null || to.isEmpty()) {
            return 0L;
        }

        try {
            Date lastWrittenTimestamp = S_DATE_FORMAT.parse(from);
            Date lastReceivedTimestamp = S_DATE_FORMAT.parse(to);
            long delayTime = (lastReceivedTimestamp.getTime() - lastWrittenTimestamp.getTime()) / 1000;
            return delayTime;
        } catch(Exception e) {
            return 0L;
        }
    }

}
