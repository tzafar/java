import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


/**
 * Created by ZafarT on 17/07/2018.
 */
@RunWith(JUnitPlatform.class)
public class GreetingsTestWithJunit5 {
    @BeforeEach
    public void setup(){
        System.out.println("In setup()");
    }

    @Test
    public void geetMethodShouldNotReturnNull(){
        System.out.println("geetMethodShouldNotReturnNull");
        Greetings greetings = new Greetings();
        String result = greetings.greet("touseef");
        Assertions.assertNotNull(result);
    }

    @Test
    public void geetMethodShouldReturnValidResults(){
        System.out.println("geetMethodShouldReturnValidResults");
        Greetings greetings = new Greetings();
        String result = greetings.greet("touseef");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("hello touseef",result);
    }

    @AfterEach
    public void clearnUP(){
        System.out.println("cleanUp");
    }
}
