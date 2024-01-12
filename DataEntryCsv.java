package JavaProjects.GUITrials;

import com.opencsv.bean.CsvBindByPosition;

public class DataEntryCsv {
    
    @CsvBindByPosition(position = 0)
    public String date;

    @CsvBindByPosition(position = 1)
    public String model;

    @CsvBindByPosition(position = 2)
    public String nmbr;

    @CsvBindByPosition(position = 3)
    public String student;

    @CsvBindByPosition(position = 4)
    public String grade;

    public DataEntryCsv() {
        this.date = "";
        this.model = "";
        this.nmbr = "";
        this.student = "";
        this.grade = "";
    }

    // Constructor to initialize data entry
    public DataEntryCsv(String date, String model, String nmbr, String student, String grade) {
        this.date = date;
        this.model = model;
        this.nmbr = nmbr;
        this.student = student;
        this.grade = grade;
    }

    // Getter methods for date, model, and student
    public String getDate() {
        return date;
    }

    public String getModel() {
        return model;
    }

    public String getNmbr() {
        return nmbr;
    }

    public String getStudent() {
        return student;
    }

    public String getGrade(){
        return grade;
    }
}
