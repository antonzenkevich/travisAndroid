package projectApp.pages.base;

import java.util.Calendar;

public class CurrentYear {

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
