package io.example.library.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class DateUtils {
    public static final String MM_DD_YYYY = "MM/dd/yyyy";

    public static Instant getInstantFromString(String dateString) throws ParseException {
        if (dateString == null || dateString.isEmpty()) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(MM_DD_YYYY);
        return sdf.parse(dateString).toInstant();
    }
}