import junit.framework.TestCase;
import models.Building;
import models.Classroom;

/**
 * Created by timothytran on 4/20/17.
 */
public class ClassroomTest extends TestCase {
    Building building;
    Classroom classroom;

    public void setUp() {
        building = new Building("McBryde", "Stub");
        classroom = new Classroom(128, building);
    }

    public void testGetNumber() {
        assertEquals(classroom.getNumber(), 128);
    }

    public void testSetNumber() {
        classroom.setNumber(129);
        assertEquals(classroom.getNumber(), 129);
    }

    public void testGetBuilding() {
        assertEquals(classroom.getBuilding(), building);
    }

    public void testSetBuilding() {
        Building build = new Building("Torg", "stubby");
        classroom.setBuilding(build);
        assertEquals(classroom.getBuilding(), build);
    }

}
