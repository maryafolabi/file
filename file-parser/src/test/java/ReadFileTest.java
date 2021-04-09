
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;


import static org.junit.jupiter.api.Assertions.*;

public class ReadFileTest {

    ReadFile firstFile, secondFile, thirdFile;

    //Before each ensures the stated happens before any test is carried out

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        firstFile = new ReadFile("config.txt");
        secondFile = new ReadFile("config.txt.dev");
        thirdFile = new ReadFile("config.txt.staging");
    }


    // the tests below checks for a match between expected and actual values of each queries
     @Test
    public void testDbname(){
        assertEquals("sq04_db", firstFile.get("dbname"));
        assertNotEquals("sq04_db-development", firstFile.get("dbname"));

         assertEquals("sq04_db-development", secondFile.get("dbname"));
         assertNotEquals("sq04_db", secondFile.get("dbname"));

         assertEquals("sq04_db", thirdFile.get("dbname"));
         assertNotEquals("sq04_db-development", thirdFile.get("dbname"));
     }

     @Test
    public void testHost(){
        assertEquals("127.0.0.1", firstFile.get("host"));
        assertNotEquals("126.7.7.0", firstFile.get("host"));

        assertEquals("127.0.0.1", secondFile.get("host"));
        assertNotEquals("234.3.4.5", secondFile.get("host"));

        assertEquals("127.0.0.1", thirdFile.get("host"));
        assertNotEquals("456.6.7", thirdFile.get("host"));
     }

     @Test
    public void testApplicationName(){
        assertEquals("fintek", firstFile.get("application.name"));
        assertNotEquals("fintrack", firstFile.get("application.name"));

        assertEquals("fintek-development", secondFile.get("application.name"));
        assertNotEquals("finbot", secondFile.get("application.name"));

        assertEquals("fintek-staging", thirdFile.get("application.name"));
        assertNotEquals("fintock", thirdFile.get("application.name"));
     }

     @Test
    public void testApplicationPort(){
        assertEquals("8080", firstFile.get("application.port"));
        assertNotEquals("0000", firstFile.get("application.port"));

        assertEquals("8082", secondFile.get("application.port"));
        assertNotEquals("1111", secondFile.get("application.port"));

        assertEquals("8081", thirdFile.get("application.port"));
        assertNotEquals("2222", thirdFile.get("application.port"));
     }


     @Test
    public void testContextUrl(){
        assertEquals("/api/v1", firstFile.get("application.context-url"));
        assertNotEquals("/wewr/ww", firstFile.get("application.context-url"));

        assertEquals("/api/v1", secondFile.get("application.context-url"));
        assertNotEquals("ghj/y/h/", secondFile.get("application.context-url"));

        assertEquals("/api/v1", thirdFile.get("application.context-url"));
        assertNotEquals("vbn/gh", thirdFile.get("application.context-url"));
     }


     @Test
    public void testMode(){
        assertEquals("production", firstFile.get("mode"));
        assertNotEquals("prod", firstFile.get("mode"));

        assertEquals("development", secondFile.get("mode"));
        assertNotEquals("dev", secondFile.get("mode"));

        assertEquals("staging", thirdFile.get("mode"));
        assertNotEquals("stage", thirdFile.get("mode"));
     }

     @Test
    public void testTheme(){
        assertEquals("green", firstFile.get("theme"));
        assertNotEquals("blue", firstFile.get("theme"));

        assertEquals("yellow", secondFile.get("theme"));
        assertNotEquals("black", secondFile.get("theme"));

        assertEquals("blue", thirdFile.get("theme"));
        assertNotEquals("coral", thirdFile.get("theme"));
     }

     @Test
    public void testPipeline(){
        assertEquals("fast", firstFile.get("pipeline"));
        assertNotEquals("slow", firstFile.get("pipeline"));

        assertEquals("fast-development", secondFile.get("pipeline"));
        assertNotEquals("fast-dev", secondFile.get("pipeline"));

        assertEquals("fast-staging", thirdFile.get("pipeline"));
        assertNotEquals("fast-stag", thirdFile.get("pipeline"));
     }
}