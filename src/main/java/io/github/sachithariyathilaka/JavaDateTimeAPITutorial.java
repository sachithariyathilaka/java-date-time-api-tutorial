package io.github.sachithariyathilaka;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Main class for the tutorial.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/05/25
 */
public class JavaDateTimeAPITutorial {

    public static void main(String[] args) {

        // local date time
        localDateTime();

        // zoned date time
        zonedDateTime();

        // period
        period();

        // duration
        duration();

        // chronos units
        chronosUnits();

        // temporal adjusters
        temporalAdjusters();
    }

    /**
     * Local date time.
     */
    private static void localDateTime() {

        // local date
        LocalDate localDate = LocalDate.now();
        Month month = localDate.getMonth();
        int date = localDate.getDayOfMonth();

        print("Local date is: " + localDate);
        print("Current month is: " + month);
        print("Current date is: " + date);

        // local time
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();

        print("Local time is: " + localTime);
        print("Current hour is: " + hour);
        print("Current minute is: " + minute);
        print("Current second is: " + second);

        // local date time
        LocalDateTime localDateTime = LocalDateTime.now();
        print("Local date time is: " + localDateTime);
    }

    /**
     * Zoned date time.
     */
    private static void zonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneId timeZone = zonedDateTime.getZone();
        Month month = zonedDateTime.getMonth();
        int date = zonedDateTime.getDayOfMonth();
        int hour = zonedDateTime.getHour();
        int minute = zonedDateTime.getMinute();
        int second = zonedDateTime.getSecond();

        print("Zoned date time is: " + zonedDateTime);
        print("Time Zone is: " + timeZone);
        print("Current month is: " + month);
        print("Current date is: " + date);
        print("Current hour is: " + hour);
        print("Current minute is: " + minute);
        print("Current second is: " + second);
    }

    /**
     * Period.
     */
    private static void period() {
        LocalDate currentDate = LocalDate.now();
        LocalDate independentDate = LocalDate.of(1948, Month.FEBRUARY, 4);
        Period gap = Period.between(independentDate, currentDate);

        print("Independent date is: " + independentDate);
        print("Current date is: " + currentDate);
        print("Gap between independent date and current date is: " + gap.getYears() + " Years " + gap.getMonths() + " Months " + gap.getDays() + " Days");
    }

    /**
     * Duration.
     */
    private static void duration() {
        LocalTime currentTime = LocalTime.now();
        LocalTime midNight = LocalTime.of(0, 0, 0);
        Duration duration = Duration.between(midNight, currentTime);
        long seconds = duration.getSeconds() % 60;
        long minutes = (duration.getSeconds() / 60) % 60;
        long hours = duration.getSeconds() / 3600;


        print("mid night time is: " + midNight);
        print("Current time is: " + currentTime);
        print("Duration between mid night and current time is: " + hours + " Hours " + minutes + " Minutes " + seconds + " Seconds");
    }

    /**
     * Chrono units.
     */
    private static void chronosUnits() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plus(1, ChronoUnit.YEARS).plus(2, ChronoUnit.MONTHS).plus(5, ChronoUnit.DAYS);

        print("Current date is: " + currentDate);
        print("Future date is: " + futureDate);

        LocalTime currentTime = LocalTime.now();
        LocalTime  futureTime = currentTime.plus(2, ChronoUnit.HOURS).plus(20, ChronoUnit.MINUTES).plus(10, ChronoUnit.SECONDS);

        print("Current time is: " + currentTime);
        print("Future time is: " + futureTime);
    }

    /**
     * Temporal adjusters.
     */
    private static void temporalAdjusters() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfNextMonth = currentDate.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate nextFriday = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate lastDayOfYear = currentDate.with(TemporalAdjusters.lastDayOfYear());
        LocalDate lastSundayOfMonth = currentDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));

        print("Current date is: " + currentDate);
        print("First date of next month is: " + firstDayOfNextMonth);
        print("Next friday is: " + nextFriday);
        print("Last day of the year is: " + lastDayOfYear);
        print("Last sunday of the month is: " + lastSundayOfMonth);
    }

    /**
     * Print the output string.
     *
     * @param   output the output
     */
    private static void print(String output) {
        System.out.println(output);
    }
}
