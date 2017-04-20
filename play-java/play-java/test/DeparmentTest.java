import junit.framework.TestCase;
import models.Department;

/**
 * Created by timothytran on 4/20/17.
 */
public class DeparmentTest extends TestCase {

    Department department;
    public void setUp() {
        department = new Department("CS");
    }

    public void testGetName() {
        assertEquals(department.getName(), "CS");
    }

    public void testSetName() {
        department.setName("CPE");
        assertEquals(department.getName(), "CPE");
    }

}
