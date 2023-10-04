package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private final static String DEFAULT_DATE_TIME = "dd MMM yyyy";
    public static String convertDateStringToDateStringByFormat(String dateString, String dateFormat) throws ParseException {
        SimpleDateFormat subFormat = new SimpleDateFormat(dateFormat);
        Date convertDate = subFormat.parse(dateString);
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME);
        return format.format(convertDate);
    }
}
