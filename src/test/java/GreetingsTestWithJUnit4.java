import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by ZafarT on 17/07/2018.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class GreetingsTestWithJUnit4 {
    @Before
    public void setup(){
        System.out.println("In setup()");
    }

    @Test
    public void geetMethodShouldNotReturnNull(){
        System.out.println("geetMethodShouldNotReturnNull");
        Greetings greetings = new Greetings();
        String result = greetings.greet("touseef");
        Assert.assertNotNull(result);
    }

    @Test
    public void geetMethodShouldReturnValidResults(){
        System.out.println("geetMethodShouldReturnValidResults");
        Greetings greetings = new Greetings();
        String result = greetings.greet("touseef");
        Assert.assertNotNull(result);
        Assert.assertEquals("hello touseef",result);
    }

    @After
    public void clearnUP(){
        System.out.println("cleanUp");
    }

}
