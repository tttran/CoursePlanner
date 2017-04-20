import junit.framework.TestCase;
import models.Building;
import models.ClassSection;

import java.util.List;

/**
 * Created by timothytran on 4/19/17.
 */
public class BuildingTest extends TestCase {

    Building test;
    public void setUp() {
        test = new Building("name", "mapsName");
    }

    public void testGetName() {
        assertEquals(test.getName(), "name");
    }

    public void testSetName() {
        test.setName("Squires");
        assertEquals(test.getName(), "Squires");
    }

    public void testGetMapsName() {
        assertEquals(test.getMapsName(), "mapsName");
    }

    public void testSetMapsName() {
        test.setMapsName("test");
        assertEquals(test.getName(), "test");
    }


}

