package gui.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChooseFileTest {

    private ChooseFile chooseFile;

    @BeforeEach
    public void setUp() {
        chooseFile = new ChooseFile();
    }

    @Test
    public void name() {
        assertNotNull(chooseFile);
    }

    @Test
    public void chooseFileProcess() {
    }
}