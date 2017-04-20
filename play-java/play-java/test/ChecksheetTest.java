import junit.framework.TestCase;
import models.*;
import models.Class;
import models.TimeBlock.Day;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timothytran on 4/19/17.
 */
public class ChecksheetTest extends TestCase {

    private Checksheet checksheet;
    private Term term;
    //private List<ClassSection> classSections;
    //private List<Class> classList;

    public void setUp() {

        term = new Term("Spring", 2017);
        checksheet = new Checksheet("Spring2017", term);
    }

    public void testGetName() {
        assertEquals(checksheet.getName(), "Spring2017");
    }

    public void testSetName() {
        checksheet.setName("Spring2018");
        assertEquals(checksheet.getName(), "Spring2018");
    }

    public void testGetTerm() {
        assertEquals(checksheet.getTerm(), term);
    }

    public void testSetTerm() {
        Term term2 = new Term("Hi", 2010);
        checksheet.setTerm(term2);
        assertEquals(checksheet.getTerm(), term2);
    }

    public void testGetAndRemoveClassSections() {
        Building building = new Building("Stub", "Stub");
        Classroom classroom = new Classroom(1234, building);
        Day day = Day.MWF;
        TimeBlock block = new TimeBlock(7, 9, day);
        Term term = new Term("Spring", 2017);
        Department department = new Department("CS");
        Class classCode = new Class("CS101", 101, department);
        ClassSection x = new ClassSection(123, classroom, block, term, classCode);

       //get
        checksheet.addClassSection(x);
        List<ClassSection> l = new ArrayList<ClassSection>();
        l.add(x);
        assertEquals(checksheet.getClassSections(),l);

        //remove
        checksheet.removeClassSection(x);
        l.remove(x);
        assertEquals(checksheet.getClassSections(),l);
    }

    public void testGetAndRemoveClassList() {
        List<Class> classList = new ArrayList<Class>();
        Department department = new Department("CS");
        Class x = new Class("CS101", 101, department);

        //get
        classList.add(x);
        checksheet.addClass(x);
        assertEquals(checksheet.getClassList(), classList);

        //remove
        classList.remove(x);
        checksheet.removeClass(x);
        assertEquals(checksheet.getClassList(), classList);
    }


}
