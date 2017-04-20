import junit.framework.TestCase;
import models.Term;

/**
 * Created by timothytran on 4/20/17.
 */
public class TermTest extends TestCase {

    Term term;
    public void setUp() {
        term = new Term("Spring", 2017);
    }

    public void testGetSemester() {
        assertEquals(term.getSemester(), "Spring");
    }

    public void testSetSemester() {
        term.setSemester("Fall");
        assertEquals(term.getSemester(), "Fall");
    }

    public void testGetYear() {
        assertEquals(term.getYear(), 2017);
    }

    public void testSetYear() {
        term.setYear(2018);
        assertEquals(term.getYear(), 2018);
    }
}
