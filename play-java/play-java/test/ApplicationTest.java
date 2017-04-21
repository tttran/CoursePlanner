import controllers.HomeController;
import models.Database;
import net.fortuna.ical4j.model.Calendar;
import org.junit.Test;
import play.twirl.api.Content;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 * This class contains tests for the use cases, done by testing the views are created correctly.
 *
 */
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("Your new application is ready."));
    }

    @Test
    public void testChecksheetView() {
        Content html = views.html.checksheet.render(Database.exampleSheet);
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("Spring 2017"));
    }

    @Test
    public void testMapView() {
        Content html = views.html.maps.render("McBryde Hall, Blacksburg, VA");
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("iframe"));
    }

    @Test
    public void testDirectionsView() {
        Content html = views.html.directions.render("Randolph Hall, Blacksburg, VA","McBryde Hall, Blacksburg, VA");
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("iframe"));
    }

    @Test
    public void testExport() {
        Calendar calendar = new HomeController().createCalendar(Database.exampleSheet);
        assertEquals(calendar.getComponents().size(), 12);
    }



}
