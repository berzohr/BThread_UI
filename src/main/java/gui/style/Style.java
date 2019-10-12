package gui.style;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Style {
    protected final static String path = (new File("src/main/resources/Style.css")).getAbsolutePath().replace("\\", "/");

    public static String getCSS() {
        return path;
    }

    public static String getHour() {
        final LocalTime localTime = LocalTime.now();
        String time = localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + " ";
        return time;
    }
}
