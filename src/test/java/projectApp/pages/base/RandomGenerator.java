package projectApp.pages.base;

import java.text.SimpleDateFormat;

public class RandomGenerator {

    public static String getRandomString(String string) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return string + timeStamp;
    }
}
