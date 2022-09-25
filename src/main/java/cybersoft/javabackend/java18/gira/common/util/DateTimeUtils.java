package cybersoft.javabackend.java18.gira.common.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtils {
    public static final String DATE_TIME_FORMAT = "HH:mm:ss dd-MM-yyyy";

    public static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    public static String now() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

}
