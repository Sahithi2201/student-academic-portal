


package vcube.Model;

public class Timetable {

    private int id;
    private String day;
    private String period;
    private String subject;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}

