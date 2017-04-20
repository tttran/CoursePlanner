package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 4/16/2017.
 */
public class Checksheet {
    private String name;
    private Term term;
    private List<ClassSection> classSections;
    private List<Class> classList;

    public Checksheet(String name, Term term) {
        this.name = name;
        this.term = term;
        classSections = new ArrayList<ClassSection>();
        classList = new ArrayList<Class>();
    }

    public Checksheet(String name, Term term, List<ClassSection> classSections, List<Class> classList) {
        this.name = name;
        this.term = term;
        if (classSections != null)
        {
            this.classSections = classSections;
        }
        else
        {
            this.classSections = new ArrayList<ClassSection>();
        }
        if (classList != null)
        {
            this.classList = classList;
        }
        else
        {
            this.classList = new ArrayList<Class>();
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public List<ClassSection> getClassSections() {
        return classSections;
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void addClassSection(ClassSection classSection){
        classSections.add(classSection);
    }

    public void addClass(Class classCode){
        classList.add(classCode);
    }

    public boolean removeClassSection(ClassSection classSection){
        return classSections.remove(classSection);
    }

    public boolean removeClass(Class classCode){
        return classList.remove(classCode);
    }

    public ClassSection getPreviousClass(ClassSection section){
        ClassSection previous = null;
        int start = section.getBlock().getStartTime();
        for(ClassSection s : classSections)
        {
            if (sameDay(section, s) && s != section && s.getBlock().getEndTime() < section.getBlock().getStartTime() &&
                    (previous == null || start - s.getBlock().getEndTime() < start - previous.getBlock().getEndTime() ))
            {
                previous = s;
            }
        }
        return previous;
    }

    private boolean sameDay(ClassSection a, ClassSection b)
    {
        return a.getBlock().getDay() == b.getBlock().getDay()
                || (a.getBlock().getDay() == TimeBlock.Day.MW && b.getBlock().getDay() == TimeBlock.Day.MWF)
                || (a.getBlock().getDay() == TimeBlock.Day.MWF && b.getBlock().getDay() == TimeBlock.Day.MW);
    }
}
