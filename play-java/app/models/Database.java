package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 4/18/2017.
 * Database spoofing class.
 */
public class Database {

    public static Map<String, Building> buildings = new HashMap<String, Building>() {
        {
            put("McBryde", new Building("McBryde", "McBryde Hall, Blacksburg, VA"));
            put("Surge", new Building("Surge","Surge Space Building, Blacksburg, VA"));
            put("Lavery", new Building("Lavery","Lavery Hall, Blacksburg, VA"));
            put("Torg", new Building("Torgesen Hall", "Torgesen Hall, Blacksburg, VA"));
            put("NCB", new Building("New Classroom Building", "New Classroom Building, Blacksburg, VA"));
            put("Randolph", new Building("Randolph", "Randolph, Blacksburg, VA"));
        }
    };

    public static Map<String, Department> departments = new HashMap<String, Department>() {
        {
            put("CS", new Department("CS"));
            put("MATH", new Department("MATH"));
        }
    };

    public static Map<String, Class> classes = new HashMap<String, Class>() {
        {
            put("CS 3704", new Class("Intermed Software Des",3704, departments.get("CS")));
            put("CS 3304", new Class("Comparative Languages", 3304,departments.get("CS")));
            put("CS 4104", new Class("Data and Algorithm Analysis", 4104, departments.get("CS")));
            put("MATH 4134", new Class("Number Theory",4134, departments.get("MATH")));
            put("MATH 4176", new Class("Cryptography",4176, departments.get("MATH")));
        }
    };

    public static Map<String, Term> terms = new HashMap<String, Term>() {
        {
            put("Spring 2017", new Term("Spring", 2017));
        }
    };

    public static Map<String, Classroom> classrooms = new HashMap<String, Classroom>() {
        {
            put("TORG 3100", new Classroom(3100, buildings.get("Torg")));
            put("MCB 304", new Classroom(304, buildings.get("McBryde")));
            put("SURGE 107", new Classroom(107, buildings.get("Surge")));
            put("NCB 250", new Classroom(250, buildings.get("NCB")));
            put("RAND 116", new Classroom(116, buildings.get("Randolph")));
        }
    };

    public static Map<String, TimeBlock> timeBlocks = new HashMap<String, TimeBlock>() {
        {
            put("8T", new TimeBlock(480,555, TimeBlock.Day.TUESDAY));
            put("14T", new TimeBlock(840, 915,TimeBlock.Day.TUESDAY));
            put("12M", new TimeBlock(740, 790, TimeBlock.Day.MONDAY));
            put("13M", new TimeBlock(805,855, TimeBlock.Day.MONDAY));
            put("14M", new TimeBlock(870, 945,TimeBlock.Day.MONDAY));
        }
    };

    public static List<ClassSection> classSectionList = new ArrayList<ClassSection>() {
        {
            add(new ClassSection(12605,classrooms.get("TORG 3100"),timeBlocks.get("8T"),terms.get("Spring 2017"),classes.get("CS 3304")));
            add(new ClassSection(15513,classrooms.get("MCB 304"),timeBlocks.get("13M"),terms.get("Spring 2017"),classes.get("MATH 4176")));
            add(new ClassSection(12616,classrooms.get("SURGE 107"),timeBlocks.get("14T"),terms.get("Spring 2017"),classes.get("CS 4104")));
            add(new ClassSection(12612,classrooms.get("NCB 250"),timeBlocks.get("14M"),terms.get("Spring 2017"),classes.get("CS 3704")));
            add(new ClassSection(15511,classrooms.get("RAND 116"),timeBlocks.get("13M"),terms.get("Spring 2017"),classes.get("MATH 4134")));
        }
    };


}
