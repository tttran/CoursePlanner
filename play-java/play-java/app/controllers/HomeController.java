package controllers;

import models.Checksheet;
import models.ClassSection;
import models.Database;
import models.TimeBlock;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.checksheet;
import views.html.directions;
import views.html.maps;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Checksheet exampleSheet = Database.exampleSheet;
        return ok(checksheet.render(exampleSheet));

    }

    public Result map(String mapsName) {

        return ok(maps.render(mapsName));
    }

    public Result directions(String place1, String place2)
    {
        return ok(directions.render(place1, place2));
    }

    public Result export(String checksheetName){

        //Spoof call to database to find checksheetName
        Checksheet checksheet = Database.exampleSheet;

        Calendar cal= new Calendar();
        cal.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
        cal.getProperties().add(Version.VERSION_2_0);
        cal.getProperties().add(CalScale.GREGORIAN);

        UidGenerator ug = null;
        try {
            ug = new UidGenerator("1");
        } catch (SocketException e) {
            e.printStackTrace();
        }

        for (ClassSection classSection : checksheet.getClassSections())
        {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            int[] days = {java.util.Calendar.MONDAY};
            if (classSection.getBlock().getDay() == TimeBlock.Day.MW)
            {
                days = new int[2];
                days[0] = java.util.Calendar.MONDAY;
                days[1] = java.util.Calendar.WEDNESDAY;
            }
            else if (classSection.getBlock().getDay() == TimeBlock.Day.MWF)
            {
                days = new int[3];
                days[0] = java.util.Calendar.MONDAY;
                days[1] = java.util.Calendar.WEDNESDAY;
                days[2] = java.util.Calendar.FRIDAY;
            }
            else if (classSection.getBlock().getDay() == TimeBlock.Day.TR)
            {
                days = new int[2];
                days[0] = java.util.Calendar.TUESDAY;
                days[1] = java.util.Calendar.THURSDAY;
            }

            for (int day : days)
            {
                while (calendar.get(java.util.Calendar.DAY_OF_WEEK) != day) {
                    calendar.add(java.util.Calendar.DATE, 1);
                }
                calendar.set(java.util.Calendar.HOUR_OF_DAY, classSection.getBlock().getStartTime() / 60);
                calendar.set(java.util.Calendar.MINUTE, classSection.getBlock().getStartTime() % 60);
                calendar.set(java.util.Calendar.SECOND, 0);

                java.util.Calendar endDate = (java.util.Calendar) calendar.clone();
                endDate.set(java.util.Calendar.HOUR_OF_DAY, classSection.getBlock().getEndTime() / 60);
                endDate.set(java.util.Calendar.MINUTE, classSection.getBlock().getEndTime() % 60);
                endDate.set(java.util.Calendar.SECOND, 0);
                VEvent event = new VEvent(new DateTime(calendar.getTime()),new DateTime(endDate.getTime()),classSection.getClassCode().getName());
                event.getProperties().add(ug.generateUid());
                cal.getComponents().add(event);
            }
        }


        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        CalendarOutputter outputter = new CalendarOutputter();

        try {
            outputter.output(cal, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response().setHeader("Content-disposition","attachment; filename=calendar.ics");
        return ok(stream.toByteArray());
    }
}
