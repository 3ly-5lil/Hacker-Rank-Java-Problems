package solved;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;


public class Cal {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        int year = 2015, month = 8, day = 5;

        calendar.set(year, month - 1, day);

        System.out.println(
                calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG,
                Locale.getDefault()
        ).toUpperCase());
    }
}
