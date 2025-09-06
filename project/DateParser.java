package project;

import java.time.*;
import java.time.format.*;

class DateParser {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static ZoneId zone = ZoneId.systemDefault();

    public static long toLong(String time) {
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        Instant instant = dateTime.atZone(zone).toInstant();
        long millis = instant.toEpochMilli();
        return millis;
    }

    public static LocalDateTime toLocalDateTime(String time) {
        return LocalDateTime.parse(time, formatter);
    }

}
