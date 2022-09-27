package by.hoitan.rent.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {

    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    private LocalDateFormatter() {
    }

    public static LocalDate format(String date){
        return LocalDate.parse(date,FORMATTER);
    }
}
