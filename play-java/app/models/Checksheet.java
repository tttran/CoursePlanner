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
}
