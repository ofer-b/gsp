import org.hp.com.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ConfigurationTest {

    @Test
    public void testGetExistingString() throws Exception {
        String string = Configuration.INSTANCE.getString("string.value", "default value");
        assertEquals("bla bla", string);
    }

    @Test
    public void testGetDefaultValueString() throws Exception {
        String string = Configuration.INSTANCE.getString("string.value.not.exists", "default value");
        assertEquals("default value", string);
    }

    @Test
    public void testGetExistingInt() throws Exception {
        Integer integer = Configuration.INSTANCE.getInteger("int.value", 7);
        assertEquals(5, integer.intValue());
    }

    @Test
    public void testGetDefaultValueInt() throws Exception {
        Integer integer = Configuration.INSTANCE.getInteger("int.value.not.exists", 7);
        assertEquals(7, integer.intValue());
    }
}
