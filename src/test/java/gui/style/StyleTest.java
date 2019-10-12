package gui.style;

import org.junit.Test;

import java.io.File;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class StyleTest {

    private final String path = (new File("src/main/resources/Style.css")).getAbsolutePath().replace("\\", "/");


    @Test
    public void getCSS() {
        assertEquals(path, Style.getCSS());
    }

    @Test
    public void getHour() {
        final LocalTime localTime = LocalTime.now();
        String time = localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + " ";
        assertEquals(time, Style.getHour());
    }
}