package gui.view;

import org.junit.Before;
import org.junit.Test;

public class JavaFXInitTest {

    private static boolean isJavaFXIsSetup;

    @Before
    public void init() throws InterruptedException{
        if(!isJavaFXIsSetup){
            JavaFXInitializer.initialize();
            isJavaFXIsSetup = true;
        }
    }

    @Test
    public void testInit() throws InterruptedException {
        JavaFXInitTest jinit = new JavaFXInitTest();
        jinit.init();
    }
}
