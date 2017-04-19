package models;

/**
 * Created by Justin on 4/16/2017.
 */
public class ClassSection {
    private int CRN;
    private Classroom classroom;
    private TimeBlock block;
    private Term term;
    private Class classCode;

    public ClassSection(int CRN, Classroom classroom, TimeBlock block, Term term, Class classCode) {
        this.CRN = CRN;
        this.classroom = classroom;
        this.block = block;
        this.term = term;
        this.classCode = classCode;
    }

    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public TimeBlock getBlock() {
        return block;
    }

    public void setBlock(TimeBlock block) {
        this.block = block;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Class getClassCode() {
        return classCode;
    }

    public void setClassCode(Class classCode) {
        this.classCode = classCode;
    }
}
