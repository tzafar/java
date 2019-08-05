package unittestlist;

import org.junit.Test;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

public class UnitTestList {

    @Test
    public void testList(){
        List<String> actual = Arrays.asList("a","b");
        List<String> expected = Arrays.asList("a","b");

        assertThat(actual,is(expected));

        assertThat(actual,hasItems("b"));
        assertThat(actual,is(instanceOf(List.class)));
        assertThat(actual,hasSize(2));
        assertThat(actual.size(),is(3));


    }
}
