import junit.framework.TestCase;
import models.TimeBlock;

/**
 * Created by timothytran on 4/20/17.
 */
public class TimeBlockTest extends TestCase {


    TimeBlock block;
    public void setUp() {
        block = new TimeBlock(7, 9, TimeBlock.Day.MWF);
    }

    public void testGetStartTime() {
        assertEquals(block.getStartTime(), 7);
    }


    public void testSetStartTime() {
        block.setStartTime(8);
        assertEquals(block.getStartTime(), 8);
    }

    public void testGetEndTime() {
        assertEquals(block.getEndTime(), 9);
    }

    public void testSetEndTime() {
        block.setEndTime(10);
        assertEquals(block.getEndTime(), 10);
    }

    public void testGetDay() {
        assertEquals(block.getDay(), TimeBlock.Day.MWF);
    }

    public void testSetDay() {
        block.setDay(TimeBlock.Day.MWF);
        assertEquals(block.getDay(), TimeBlock.Day.MWF);
    }
}
