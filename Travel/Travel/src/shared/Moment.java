package shared;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * You can add anything to this class, but not
 * remove it
 * rename it
 * move it to another package
 * modify the constructor
 * modify the existing date, time, isValidDate, isValidTime, getMomentAfter, compareTo members and methods
 */
public class Moment implements Comparable<Moment> {
    public String date;
    public String time;

    public Moment(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidTime(String time) {
        try {
            LocalTime.parse(time);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static Moment getMomentAfter(String startDate, String startTime, String timeToAdd) {
        try {
            LocalDate d1 = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime t1 = LocalTime.parse(startTime);
            LocalDateTime start = LocalDateTime.of(d1, t1);

            String[] tt = timeToAdd.split(":");
            Duration duration = Duration.ofHours(Long.parseLong(tt[0])).plus(Duration.ofMinutes(Long.parseLong(tt[1])));
            LocalDateTime end = start.plus(duration);

            String d2 = end.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String t2 = end.format(DateTimeFormatter.ofPattern("HH:mm"));
            return new Moment(d2, t2);
        } catch (DateTimeParseException | ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public int compareTo(Moment o) {
        if (!isValidDate(this.date) || !isValidTime(this.time)) {
            return -1;
        }
        if (!isValidDate(o.date) || !isValidTime(o.time)) {
            return 1;
        }

        LocalDate d1 = LocalDate.parse(this.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime t1 = LocalTime.parse(this.time);
        LocalDateTime dt1 = LocalDateTime.of(d1, t1);

        LocalDate d2 = LocalDate.parse(o.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime t2 = LocalTime.parse(o.time);
        LocalDateTime dt2 = LocalDateTime.of(d2, t2);
        return dt1.compareTo(dt2);
    }
}
