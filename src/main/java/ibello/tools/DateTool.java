package ibello.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTool {
    
    public static String localDateToString(LocalDate date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(pattern);
    }
    
}
