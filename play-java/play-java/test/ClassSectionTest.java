import junit.framework.TestCase;
import models.*;
import models.Class;

/**
 * Created by timothytran on 4/20/17.
 */
public class ClassSectionTest extends TestCase {


    private ClassSection classsection;
    private Classroom classroom;
    private TimeBlock timeblock;
    private Term term;
    private Department department;
    private Class classcode;
    public void setUp() {
        Building building = new Building("Mybryde", "Stub");
        classroom = new Classroom(128, building);
        timeblock = new TimeBlock(8, 10, TimeBlock.Day.TUESDAY);
        term = new Term("Spring", 2017);
        department = new Department("CS");
        classcode = new Class("CS101", 101, department);
        classsection = new ClassSection(12345, classroom, timeblock, term, classcode);
    }


    public void testGetCRN() {
        assertEquals(classsection.getCRN(), 12345);
    }

    public void testSetCRN() {
        classsection.setCRN(123);
        assertEquals(classsection.getCRN(), 123);
    }

    public void testGetClassroom() {
        assertEquals(classsection.getClassroom(), classroom);
    }

    public void testSetClassroom() {
        Building build = new Building("torg", "Stubby");
        Classroom room = new Classroom(3100, build);
        classsection.setClassroom(room);
        assertEquals(classsection.getClassroom(), room);
    }

    public void testGetBlock() {
        assertEquals(classsection.getBlock(), timeblock);
    }

    public void testSetBlock() {
        TimeBlock block = new TimeBlock(10, 12, TimeBlock.Day.FRIDAY);
        classsection.setBlock(block);
        assertEquals(classsection.getBlock(), block);
    }

    public void testGetTerm() {
        assertEquals(classsection.getTerm(), term);
    }

    public void testSetTerm() {
        Term t = new Term("Fall", 2018);
        classsection.setTerm(t);
        assertEquals(classsection.getTerm(), t);
    }

    public void testGetClassCode() {
        assertEquals(classsection.getClassCode(), classcode);
    }

    public void testSetClassCode() {
        Class c = new Class("CS102", 102, department);
        classsection.setClassCode(c);
        assertEquals(classsection.getClassCode(), c);
    }
}
