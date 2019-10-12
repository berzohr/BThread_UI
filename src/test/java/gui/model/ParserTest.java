package gui.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;

public class ParserTest {

    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = Mockito.mock(Parser.class);
    }

    @Test
    public void create() {
        assertNotNull(parser);
    }

    @Test
    public void stringMatching() {
    }

    @Test
    public void parsingTest04() {
        parser.parsing(anyString());
        Mockito.verify(parser, Mockito.times(1)).parsing(anyString());
    }

    @Test
    public void parsingTest05() {
        parser.parsing(null);
        Mockito.verify(parser, Mockito.times(1)).parsing(null);
    }
}