import junit.framework.TestCase;
import models.Class;
import models.Department;

/**
 * Created by timothytran on 4/20/17.
 */
public class ClassTest extends TestCase {
    private Class c;
    private Department department;

    public void setUp() {
        department = new Department("CS");
        c = new Class("CS101", 101, department);
    }

    public void testGetName() {
        assertEquals(c.getName(), "CS101");
    }

    public void testSetName() {
       c.setName("CS102");
       assertEquals(c.getName(), "CS102");
    }

    public void testGetCode() {
        assertEquals(c.getCode(), 101);
    }

    public void testSetCode() {
        c.setCode(102);
        assertEquals(c.getCode(), 102);
    }

    public void testGetDepartment() {
        assertEquals(c.getDepartment(),department);
    }

    public void testSetDepartment() {
        Department depot = new Department("CPE");
        c.setDepartment(depot);
        assertEquals(c.getDepartment(), depot);
    }

}
